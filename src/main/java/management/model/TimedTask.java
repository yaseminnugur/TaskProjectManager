package management.model;

public class TimedTask extends Task {

    private Deadline deadline;

    public TimedTask(String title, String description, Priority priority, Deadline deadline) {
        super(title, description, priority);
        this.deadline = deadline;
    }


    public Deadline getDeadline() {
        return deadline;
    }
}
