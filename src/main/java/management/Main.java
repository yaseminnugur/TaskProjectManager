package management;

import management.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Project project = new Project("OOP Final Projesi");

        Task task1 = new Task(
                "Rapor Yaz",
                "Proje raporu",
                Priority.MEDIUM
        );

        Deadline deadline = new Deadline(LocalDate.now().plusDays(2));
        Task task2 = new TimedTask(
                "Sunum Hazırla",
                "Sunum dosyası",
                Priority.URGENT,
                deadline
        );

        project.addTask(task1);
        project.addTask(task2);

        System.out.println("Görevler ve öncelikleri:");
        for (Task task : project.getTasks()) {
            System.out.println(
                    "- " + task.getTitle() +
                            " | Priority: " + task.getPriority()
            );
        }
    }
}
