package management.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Görevlerin bir araya getirildiği ve yönetildiği proje sınıfıdır.
 * Bu sınıf, görevlerin eklenmesi, tamamlanması ve belirli zaman kriterlerine
 * göre filtrelenmesi işlemlerini yürüten temel iş mantığını içerir.
 * * @author Yasemin
 * @version 1.0
 */
public class Project {

    /** Projenin adı */
    private String name;

    /** Projeye atanmış görevlerin listesi */
    private List<Task> tasks;

    /**
     * Yeni bir Project nesnesi oluşturur.
     * * @param name Projenin adı
     */
    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    /**
     * Projenin adını döndürür.
     * * @return Proje adı
     */
    public String getName() {
        return name;
    }

    /**
     * Projeye yeni bir görev ekler.
     * * @param task Eklenecek {@link Task} nesnesi
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Projedeki tüm görevlerin listesini döndürür.
     * * @return {@link Task} nesnelerinden oluşan liste
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Belirlenen gün sayısı içinde teslim edilmesi gereken ve henüz
     * tamamlanmamış süreli görevleri filtreleyerek liste olarak döner.
     * * @param days Kaç günlük bir zaman diliminde arama yapılacağı
     * @return Yaklaşan süreli görevlerin ({@link TimedTask}) listesi
     */
    public List<TimedTask> getUpcomingTasks(int days) {
        List<TimedTask> upcomingTasks = new ArrayList<>();
        LocalDate now = LocalDate.now();

        for (Task task : tasks) {
            if (task instanceof TimedTask timedTask) {
                LocalDate dueDate = timedTask.getDeadline().getDueDate();
                if (!timedTask.isCompleted() &&
                        !dueDate.isBefore(now) &&
                        !dueDate.isAfter(now.plusDays(days))) {
                    upcomingTasks.add(timedTask);
                }
            }
        }
        return upcomingTasks;
    }

    /**
     * Başlık ismine göre proje içindeki bir görevi bulur ve
     * durumunu "tamamlandı" olarak günceller.
     * * @param taskTitle Tamamlanacak görevin başlığı (Büyük/küçük harf duyarsız)
     */
    public void completeTask(String taskTitle) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(taskTitle)) {
                task.complete();
                break;
            }
        }
    }
}