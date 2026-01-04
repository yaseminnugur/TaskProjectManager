package management.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Project} sınıfının iş mantığını ve davranışlarını doğrulayan
 * birim (unit) test sınıfıdır.
 * Bu sınıf, projeye görev ekleme ve yaklaşan görevleri filtreleme gibi
 * kritik fonksiyonların doğruluğunu test eder.
 * * @author Yasemin
 * @version 1.0
 */
public class ProjectTest {

    /**
     * Projeye yeni bir görev eklendiğinde, görev listesinin boyutunun
     * doğru şekilde arttığını ve görevin listeye dahil edildiğini test eder.
     */
    @Test
    void projectShouldAddTasksCorrectly() {
        Project project = new Project("Test Project");
        Task task = new Task("Task 1", "Desc", Priority.MEDIUM);

        project.addTask(task);

        assertEquals(1, project.getTasks().size());
    }

    /**
     * Belirlenen zaman dilimi (gün) içerisindeki teslim tarihi yaklaşan
     * görevlerin, filtreleme mekanizması tarafından doğru şekilde
     * tespit edilip edilmediğini test eder.
     */
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