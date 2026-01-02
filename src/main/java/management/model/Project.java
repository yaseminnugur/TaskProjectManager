package management.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void completeTask(String taskTitle) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(taskTitle)) {
                task.complete();
                break;
            }
        }
    }

}
