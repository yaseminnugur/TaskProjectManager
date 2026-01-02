package management;

import management.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Project project = new Project("OOP Final Projesi");

        Task task1 = new Task("Rapor Yaz", "Proje raporunu hazırla");

        Deadline deadline = new Deadline(LocalDate.now().plusDays(3));
        Task task2 = new TimedTask(
                "Sunum Hazırla",
                "Final sunumunu hazırla",
                deadline
        );

        project.addTask(task1);
        project.addTask(task2);

        System.out.println("Proje: " + project.getName());
        System.out.println("Görev sayısı: " + project.getTasks().size());
    }
}
