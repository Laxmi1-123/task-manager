
import java.util.*;

public class TaskService {

    private Map<Integer, Task> tasks = new HashMap<>();

    // Add Task
    public void addTask(Task t) {
        if (t == null) {
            throw new NullPointerException("Task cannot be null");
        }

        if (tasks.containsKey(t.getId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        tasks.put(t.getId(), t);
    }

    // Get Task by ID
    public Task getTask(int id) {
        return tasks.get(id);
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    // Delete Task
    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    // Update Title
    public boolean updateTitle(int id, String title) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Task t = tasks.get(id);

        if (t == null) {
            return false;
        }

        t.setTitle(title);
        return true;
    }

    // Mark Task Done
    public boolean markDone(int id) {
        Task t = tasks.get(id);

        if (t == null) {
            return false;
        }

        t.markDone();
        return true;
    }

    // Search Tasks by Title
    public List<Task> searchByTitle(String keyword) {

        List<Task> result = new ArrayList<>();

        for (Task t : tasks.values()) {
            if (t.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(t);
            }
        }

        return result;
    }

    // Get Completed Tasks
    public List<Task> getCompletedTasks() {

        List<Task> completed = new ArrayList<>();

        for (Task t : tasks.values()) {
            if (t.isDone()) {
                completed.add(t);
            }
        }

        return completed;
    }

    // Update full task (needed for BasicTest)
    public boolean updateTask(Task updatedTask) {

    if (updatedTask == null) {
        throw new NullPointerException("Task cannot be null");
    }

    Task existing = tasks.get(updatedTask.getId());

    if (existing == null) {
        return false;
    }

    existing.setTitle(updatedTask.getTitle());
    existing.setPriority(updatedTask.getPriority());

    return true;
}
}