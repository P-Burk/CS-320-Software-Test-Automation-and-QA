package Task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    @DisplayName("Constructor null check.")
    void taskConstructorNullCheck() {
        Task aTask = new Task(null, null);
        assertNotNull(aTask.getTaskName(), "Task name is NULL");
        assertNotNull(aTask.getTaskDesc(), "Task description is NULL");
        assertNotNull(aTask.getTaskID(), "Task ID is NULL");
    }

    @Test
    @DisplayName("Constructor length check.")
    void taskConstructorLengthCheck() {
        Task aTask = new Task("this is a looooooong name",
                "this is a very very super extremely looooooooooong description");
        assertEquals("this is a looooooong", aTask.getTaskName(), "Passed name too long.");
        assertEquals("this is a very very super extremely looooooooooong", aTask.getTaskDesc(),
                "Passed description too long.");
    }

    @Test
    @DisplayName("Task name setter. Cannot be NULL. Cannot be > 20 characters.")
    void setTaskNameCheck() {
        Task aTask = new Task(null, null);
        assertNotNull(aTask.getTaskName(), "Task name is NULL");
        aTask.setTaskName("this is a looooooong name");
        assertEquals("this is a looooooong", aTask.getTaskName(), "Passed name too long.");
    }

    @Test
    @DisplayName("Task description setter. Cannot be NULL. Cannot be > 50 characters.")
    void setTaskDescCheck() {
        Task aTask = new Task(null, null);
        assertNotNull(aTask.getTaskDesc(), "Task description is NULL");
        aTask.setTaskDesc("this is a very very super extremely looooooooooong description");
        assertEquals("this is a very very super extremely looooooooooong",
                aTask.getTaskDesc(), "Passed name too long.");
    }
}