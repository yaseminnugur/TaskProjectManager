package management.model;

import java.util.List;

/**
 * Kullanıcıya görevlerle ilgili bildirimlerin ve hatırlatmaların
 * sunulmasından sorumlu sınıftır.
 * Bu sınıf, proje verilerini işleyerek konsol üzerinden
 * bilgilendirme mesajları oluşturur.
 * * @author Yasemin
 * @version 1.0
 */
public class Notification {

    /**
     * Belirlenen gün sayısı içinde teslim edilmesi gereken görevleri
     * projenin içinden filtreler ve konsola rapor olarak yazdırır.
     * * @param project Analiz edilecek {@link Project} nesnesi
     * @param days Hatırlatma yapılacak zaman dilimi (gün bazında)
     */
    public void notifyUpcomingTasks(Project project, int days) {

        List<TimedTask> upcomingTasks = project.getUpcomingTasks(days);

        if (upcomingTasks.isEmpty()) {
            System.out.println("Yaklaşan görev bulunmamaktadır.");
            return;
        }

        System.out.println("Yaklaşan görev hatırlatmaları:");

        for (TimedTask task : upcomingTasks) {
            System.out.println(
                    "- " + task.getTitle() +
                            " | Deadline: " + task.getDeadline().getDueDate() +
                            " | Priority: " + task.getPriority()
            );
        }
    }
}