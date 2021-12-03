/**
 * @author Emily Elzinga
 * @version 0.1.0
 * @since 12/2/2021
 */
package edu.isu.cs.cs2263.hw02;

import javafx.scene.control.DialogPane;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(ApplicationExtension.class)
class TestHelper {

    public TestHelper(){}

    /**
     * adds some courses to the database
     * @param robot
     * @return return the course
     * @throws InterruptedException
     */
    protected List<String> addCourses(FxRobot robot) throws InterruptedException {
        Thread.sleep(5000);
        robot.clickOn("#tfName").write("Physics");
        return Arrays.asList("Physics","212","4");
    }
}
