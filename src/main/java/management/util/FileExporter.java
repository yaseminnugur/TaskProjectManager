package management.util;

import management.model.Project;
import management.model.Task;
import management.model.TimedTask;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Proje verilerini sistem dışına (dosya sistemine) aktarmak için kullanılan
 * yardımcı (utility) sınıftır.
 * Bu sınıf, verilerin kalıcı olarak saklanması veya raporlanması için
 * dosya yazma işlemlerini gerçekleştirir.
 * * @author Yasemin
 * @version 1.0
 */
public class FileExporter {

    /**
     * Verilen bir proje nesnesindeki tüm görevleri ve detaylarını
     * belirtilen bir metin dosyasına (.txt) yazdırır.
     * * @param project İçeriği dışa aktarılacak olan {@link Project} nesnesi
     * @param fileName Verilerin yazılacağı dosyanın adı veya tam yolu
     */
    public static void exportProject(Project project, String fileName) {

        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("Proje: " + project.getName() + "\n\n");

            for (Task task : project.getTasks()) {

                writer.write("Görev: " + task.getTitle() + "\n");
                writer.write("Öncelik: " + task.getPriority() + "\n");
                writer.write("Tamamlandı mı: " + task.isCompleted() + "\n");

                if (task instanceof TimedTask timedTask) {
                    writer.write("Deadline: " +
                            timedTask.getDeadline().getDueDate() + "\n");
                }

                writer.write("------------------------\n");
            }

            System.out.println("Dosyaya aktarma başarılı: " + fileName);

        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }
}