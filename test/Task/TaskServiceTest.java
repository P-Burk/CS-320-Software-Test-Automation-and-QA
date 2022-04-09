package Task;

import org.junit.jupiter.api.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskServiceTest {
    private TaskService newService;
    private String taskID1;
    private String taskID2;

    @BeforeEach
    void setUp() {
        newService = new TaskService();
        newService.addNewTask("First Task", "This is a task description.");
        taskID1 = newService.getTaskByIndex(0).getTaskID();
        newService.addNewTask("Second Task", "This is also a description.");
        taskID2 = newService.getTaskByIndex(1).getTaskID();
    }

    @AfterEach
    void tearDown() {
        newService = null;
    }

    @Test
    @Order(1)
    @DisplayName("Check the adding of tasks to task service.")
    void addNewTask() {
        assertEquals(newService.getTaskByID(taskID1), newService.getTaskByIndex(0),
                "Task not added correctly.");
        assertEquals(newService.getTaskByID(taskID2), newService.getTaskByIndex(1),
                "Task not added correctly.");
    }


    @Test
    @Order(2)
    @DisplayName("Check the updating of task description of tasks to task service.")
    void updateTaskDesc() {
        newService.updateTaskDesc(taskID1, "Updated Description");
        assertEquals("Updated Description", newService.getTaskByID(taskID1).getTaskDesc(),
                "Task description not updated correctly.");
    }

    @Test
    @Order(3)
    @DisplayName("Check the updating of task name of tasks to task service.")
    void updateTaskName() {
        newService.updateTaskName(taskID1, "Updated Name");
        assertEquals("Updated Name", newService.getTaskByID(taskID1).getTaskName(),
                "Task name not updated correctly.");
    }

    @Test
    @Order(4)
    @DisplayName("Check the deleting of a task from the task service.")
    void deleteTask() {
        newService.deleteTask(taskID1);
        assertNull(newService.getTaskByID(taskID1));
    }
}
