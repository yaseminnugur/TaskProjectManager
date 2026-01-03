package management;

import management.model.*;
import management.util.FileExporter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Project project = new Project("OOP Final Projesi");

        Task task1 = new Task(
                "Rapor Yaz",
                "Proje raporu",
                Priority.MEDIUM
        );

        Deadline deadline = new Deadline(LocalDate.now().plusDays(1));
        Task task2 = new TimedTask(
                "Sunum Hazırla",
                "Sunum dosyası",
                Priority.URGENT,
                deadline
        );

        project.addTask(task1);
        project.addTask(task2);

        task1.complete();

        FileExporter.exportProject(project, "project_output.txt");
    }
}
