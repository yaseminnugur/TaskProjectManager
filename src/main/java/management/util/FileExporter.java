package management.util;

import management.model.Project;
import management.model.Task;
import management.model.TimedTask;

import java.io.FileWriter;
import java.io.IOException;

public class FileExporter {

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
