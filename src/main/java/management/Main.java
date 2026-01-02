package management;

import management.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Project project = new Project("OOP Final Projesi");

        Task task1 = new Task("Rapor Yaz", "Proje raporu");
        Deadline deadline = new Deadline(LocalDate.now().plusDays(2));
        Task task2 = new TimedTask("Sunum Hazırla", "Sunum dosyası", deadline);

        project.addTask(task1);
        project.addTask(task2);

        project.completeTask("Rapor Yaz");

        System.out.println("Yaklaşan görevler:");
        for (TimedTask task : project.getUpcomingTasks(3)) {
            System.out.println("- " + task.getTitle() +
                    " | Deadline: " + task.getDeadline().getDueDate());
        }
    }
}
