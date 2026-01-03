package management.model;

import java.util.List;

public class Notification {

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
