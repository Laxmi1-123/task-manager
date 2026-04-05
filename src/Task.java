public class Task {
    private int id;
    private String title;
    private boolean done;
    private int priority;

    public Task(int id, String title, int priority) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Title required");
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public int getPriority() { return priority; }

    public void setTitle(String t) { this.title = t; }
    public void markDone() { done = true; }

    public void setPriority(int priority)
    {
        this.priority=priority;
    }
}