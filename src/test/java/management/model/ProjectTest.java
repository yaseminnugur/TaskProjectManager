package management.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    @Test
    void projectShouldAddTasksCorrectly() {
        Project project = new Project("Test Project");
        Task task = new Task("Task 1", "Desc", Priority.MEDIUM);

        project.addTask(task);

        assertEquals(1, project.getTasks().size());
    }

    @Test
    void projectShouldReturnUpcomingTasks() {
        Project project = new Project("Test Project");

        Deadline deadline = new Deadline(LocalDate.now().plusDays(1));
        TimedTask task = new TimedTask(
                "Timed Task",
                "Desc",
                Priority.HIGH,
                deadline
        );

        project.addTask(task);

        List<TimedTask> upcomingTasks = project.getUpcomingTasks(2);

        assertEquals(1, upcomingTasks.size());
    }
}
