/**
 * @author Emily Elzinga
 * @version 0.1.0
 * @since 12/3/2021
 */

package edu.isu.cs.cs2263.hw02;

import edu.isu.cs.cs2263.hw02.views.CoursesFormView;
import edu.isu.cs.cs2263.hw02.views.DisplayListView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class DisplayListTest extends TestHelper{
    @Mock
    App mockApp;
    @Mock
    DisplayListView mockDisplayView;

    /**
     * Starts the ui up
     * @param stage
     * @throws Exception
     */
    @Start
    protected void start(Stage stage) throws Exception {
        mockApp = new App(stage);
        mockDisplayView = new DisplayListView(mockApp);
        stage.setScene(mockApp.getScene());
        stage.show();
    }

    /**
     * Cleans the ui after each test
     * @throws Exception
     */
    @AfterEach
    public void tearDown() throws Exception {
        FxToolkit.cleanupStages();
    }

    /**
     * Tests whether the Display Courses button shows the courses list
     * @param robot
     * @throws InterruptedException
     */
    @Test
    public void displayButtonWorks(FxRobot robot) throws InterruptedException {
        Button displayButton = mockApp.getDisplay();
        robot.clickOn(displayButton);
        List<String> displayList = addCourses(robot);
        String displayString = String.join((CharSequence) displayList);

        Assertions.assertEquals(mockDisplayView.getLstCourses().getItems().get(0), displayString);
        }

    }