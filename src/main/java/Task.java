public class Task {

    private int id;
    private String title;
    private boolean done;
    private int priority;

    // Constructor
    public Task(int id, String title, int priority) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title required");
        }

        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public int getPriority() {
        return priority;
    }

    // Setters / Methods
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void markDone() {
        this.done = true;
    }
}

