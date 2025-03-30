package utez.edu.mx.tasklistinterface.Task;

public class Task {

    private long id;

    private String taskName;

    private String description;

    private String date;

    private boolean pending;

    public Task() {
    }

    public Task(long id, String taskName, String description, String date) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.date = date;
    }

    public Task(String taskName, String description, String date) {
        this.taskName = taskName;
        this.description = description;
        this.date = date;
    }

    public Task(String taskName, String description, String date, boolean pending) {
        this.taskName = taskName;
        this.description = description;
        this.date = date;
        this.pending = pending;
    }

    public Task(long id, String taskName, String description, String date, boolean pending) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.date = date;
        this.pending = pending;
    }

    public long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    @Override
    public String toString() {
        String status = pending ? "Pendiente" : "Terminado/a";
        return "\n" +
                "taskName=" + taskName + '\n' +
                "description=" + description + '\n' +
                "date=" + date + '\n' +
                "pending=" + status +
                '\n';
    }
}
