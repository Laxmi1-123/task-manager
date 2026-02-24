import java.util.*;

public class TaskService {

    private Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task t) {
        tasks.put(t.getId(), t);
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    public boolean updateTitle(int id, String title) {
        Task t = tasks.get(id);
        if (t == null) return false;
        t.setTitle(title);
        return true;
    }

    public boolean markDone(int id) {
        Task t = tasks.get(id);
        if (t == null) return false;
        t.markDone();
        return true;
    }
}