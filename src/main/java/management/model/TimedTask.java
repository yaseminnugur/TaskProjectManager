package management.model;

public class TimedTask extends Task {

    private Deadline deadline;

    public TimedTask(String title, String description, Deadline deadline) {
        super(title, description);
        this.deadline = deadline;
    }

    public Deadline getDeadline() {
        return deadline;
    }
}
