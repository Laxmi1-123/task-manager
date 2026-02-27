import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceModifyTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1,"Test",1));
        service.addTask(new Task(2,"Second",2));
    }

    // ---------------- UPDATE TESTS ----------------

    @Test
    void shouldUpdateTitleSuccessfully() {
        boolean result = service.updateTitle(1,"Updated");
        assertTrue(result);
        assertEquals("Updated", service.getTask(1).getTitle());
    }

    @Test
    void updateNonExistingTaskShouldReturnFalse() {
        boolean result = service.updateTitle(99,"NewTitle");
        assertFalse(result);
    }

    @Test
    void updateWithEmptyTitleShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateTitle(1,""));
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