package management.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Task} sınıfının temel işlevlerini ve durum değişikliklerini
 * doğrulayan birim (unit) test sınıfıdır.
 * Bir görevin yaşam döngüsü boyunca sahip olduğu tamamlanma durumlarının
 * doğruluğunu kontrol eder.
 * * @author Yasemin
 * @version 1.0
 */
public class TaskTest {

    /**
     * Yeni oluşturulan bir görevin varsayılan olarak "tamamlanmamış"
     * (incomplete) durumda olduğunu doğrular.
     */
    @Test
    void taskShouldBeIncompleteInitially() {
        Task task = new Task("Test", "Test task", Priority.LOW);
        assertFalse(task.isCompleted());
    }

    /**
     * {@link Task#complete()} metodu çağrıldığında, görevin durumunun
     * "tamamlandı" (completed) olarak güncellendiğini doğrular.
     */
    @Test
    void taskShouldBeCompletedAfterCallingComplete() {
        Task task = new Task("Test", "Test task", Priority.LOW);
        task.complete();
        assertTrue(task.isCompleted());
    }
}