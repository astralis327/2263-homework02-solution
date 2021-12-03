/**
 * @author Emily Elzinga
 * @version 0.1.0
 * @since 12/2/2021
 */

package edu.isu.cs.cs2263.hw02;

import edu.isu.cs.cs2263.hw02.views.CoursesFormView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loadui.testfx.Assertions;
import org.mockito.Mock;
import org.testfx.api.FxRobot;
import org.testfx.api.FxRobotInterface;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

//
//@ExtendWith(ApplicationExtension.class)
public class CoursesViewTest extends TestHelper{
    @Mock
    App mockApp;
    @Mock
    CoursesFormView mockCoursesView;

    @Start
    protected void start(Stage stage) throws Exception {
        mockApp = new App(stage);
        mockCoursesView = new CoursesFormView(mockApp);
        stage.setScene(mockApp.getScene());
        stage.show();
    }

    @AfterEach
    public void tearDown () throws Exception {
        FxToolkit.cleanupApplication(mockApp);
        FxToolkit.cleanupStages();
    }


}
