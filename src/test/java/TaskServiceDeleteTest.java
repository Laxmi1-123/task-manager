import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceDeleteTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1, "Test", 1));
        service.addTask(new Task(2, "Second", 2));
    }

    // ---------------- DELETE TESTS ----------------

    @Test
    void shouldDeleteTaskSuccessfully() {
        boolean result = service.deleteTask(1);
        assertTrue(result);
        assertNull(service.getTask(1));
    }

    @Test
    void deleteAlreadyDeletedTaskShouldReturnFalse() {
        service.deleteTask(1);
        boolean result = service.deleteTask(1);
        assertFalse(result);
    }

    @Test
    void deleteNonExistingTaskShouldReturnFalse() {
        assertFalse(service.deleteTask(100));
    }
}
