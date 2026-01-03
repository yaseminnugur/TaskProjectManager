package management.model;

public class Task implements Completable {

    private String title;
    private String description;
    private boolean completed;
    private Priority priority;


    public Task(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }


    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public void complete() {
        this.completed = true;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }
}
