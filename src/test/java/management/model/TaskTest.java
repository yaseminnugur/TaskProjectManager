package management.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void taskShouldBeIncompleteInitially() {
        Task task = new Task("Test", "Test task", Priority.LOW);
        assertFalse(task.isCompleted());
    }

    @Test
    void taskShouldBeCompletedAfterCallingComplete() {
        Task task = new Task("Test", "Test task", Priority.LOW);
        task.complete();
        assertTrue(task.isCompleted());
    }
}
