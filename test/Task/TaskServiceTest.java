package Task;

import org.junit.jupiter.api.*;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskServiceTest {

    //These next three parts are used so that you don't have to make a new task service and fill it
    //with testing tasks for every single JUnit test.

    //Part 1
    //initialize test list and a task service.
    private final ArrayList<TaskService> testList = new ArrayList<>();
    TaskService newTaskService = new TaskService();

    //Part 2
    //Adds two tasks to the task service, then adds the service to the test list
    @BeforeEach
    public void startService() {
        newTaskService.addNewTask("1st Task", "This is the first task.");
        newTaskService.addNewTask("2nd Task", "This is the second task.");
        testList.add(newTaskService);
    }

    //Part 3
    //delete the contact service after every test
    @AfterEach
    public void clearService() {
        testList.clear();
    }

    @Test
    @Order(1)
    @DisplayName("Check the adding of tasks to task service.")
    void addNewTask() {
        assertEquals(testList.get(0).getTaskByID("0"), testList.get(0).getTaskByIndex(0),
                "Task not added correctly.");
        assertEquals(testList.get(0).getTaskByID("1"), testList.get(0).getTaskByIndex(1),
                "Task not added correctly.");
    }


    @Test
    @Order(2)
    @DisplayName("Check the updating of task description of tasks to task service.")
    void updateTaskDesc() {
        testList.get(0).updateTaskDesc("2", "Updated Description");
        assertEquals("Updated Description", testList.get(0).getTaskByID("2").getTaskDesc(),
                "Task description not updated correctly.");
    }

    @Test
    @Order(3)
    @DisplayName("Check the updating of task name of tasks to task service.")
    void updateTaskName() {
        testList.get(0).updateTaskName("4", "Updated Name");
        assertEquals("Updated Name", testList.get(0).getTaskByID("4").getTaskName(),
                "Task name not updated correctly.");
    }

    @Test
    @Order(4)
    @DisplayName("Check the deleting of a task from the task service.")
    void deleteTask() {
        testList.get(0).deleteTask("6");
        assertNull(testList.get(0).getTaskByID("6"));
    }
}
