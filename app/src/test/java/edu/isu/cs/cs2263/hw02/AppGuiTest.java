package edu.isu.cs.cs2263.hw02;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.experimental.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.Mock;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@ExtendWith(ApplicationExtension.class)
public class AppGuiTest {
    @Mock
    App mockApp;

    @Start
    protected void start(Stage stage) throws Exception {
        mockApp = new App(stage);
        stage.setScene(mockApp.getScene());
        stage.show();
    }

    @AfterEach
    public void tearDown () throws Exception {
        FxToolkit.cleanupStages();
    }

    /**
     * make sure that the exit button is showing
     */
    @Test
    public void exitButtonShows() {
        String exitText = mockApp.getExit().getText();
        Assertions.assertEquals("Exit", exitText);
    }

    /**
     * Test functionality for the exit button
     * @param robot
     * @throws InterruptedException
     */
    @Test
    public void exitButtonWorks(FxRobot robot) throws InterruptedException {
        Button exit = mockApp.getExit();
        robot.clickOn(exit);
        Thread.sleep(2000);
        alert_dialog_has_header_and_content("Confirmation",
                "Are you sure you want to exit?", robot);
    }

    /**
     * make sure the alert that appears has the expected content
     * @param expectedHeader
     * @param expectedContent
     * @param robot
     */
    public void alert_dialog_has_header_and_content(final String expectedHeader,
                                                    final String expectedContent, FxRobot robot) {
        final javafx.stage.Stage actualAlertDialog = getTopModalStage(robot);
        Assertions.assertNotNull(actualAlertDialog);

        final DialogPane dialogPane = (DialogPane) actualAlertDialog.getScene().getRoot();
        Assertions.assertEquals(expectedHeader, dialogPane.getHeaderText());
        Assertions.assertEquals(expectedContent, dialogPane.getContentText());
    }

    private javafx.stage.Stage getTopModalStage(FxRobot robot) {
        // Get a list of windows but ordered from top[0] to bottom[n] ones.
        // It is needed to get the first found modal window.
        final List<Window> allWindows = new ArrayList<>(robot.robotContext().getWindowFinder().listWindows());
        Collections.reverse(allWindows);

        return (javafx.stage.Stage) allWindows
                .stream()
                .filter(window -> window instanceof javafx.stage.Stage)
                .filter(window -> ((javafx.stage.Stage) window).getModality() == Modality.APPLICATION_MODAL)
                .findFirst()
                .orElse(null);
    }
    
}