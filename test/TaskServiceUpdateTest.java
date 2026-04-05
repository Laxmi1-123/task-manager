import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceUpdateTest {

    @Test
    void testUpdateTitleSuccess() {
        TaskService service = new TaskService();
        Task task = new Task(1, "Old Title");

        service.addTask(task);

        boolean result = service.updateTitle(1, "New Title");

        assertTrue(result);
        assertEquals("New Title", service.getTask(1).getTitle());
    }

    @Test
    void testUpdateTitleTaskNotFound() {
        TaskService service = new TaskService();

        boolean result = service.updateTitle(99, "New Title");

        assertFalse(result);
    }

    @Test
    void testUpdateTitleNull() {
        TaskService service = new TaskService();
        Task task = new Task(1, "Test Task");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTitle(1, null);
        });
    }

    @Test
    void testUpdateTitleBlank() {
        TaskService service = new TaskService();
        Task task = new Task(1, "Test Task");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTitle(1, " ");
        });
    }

    @Test
    void testUpdateTitleMultipleTimes() {
        TaskService service = new TaskService();
        Task task = new Task(1, "Initial");

        service.addTask(task);

        service.updateTitle(1, "First Update");
        service.updateTitle(1, "Second Update");

        assertEquals("Second Update", service.getTask(1).getTitle());
    }
}