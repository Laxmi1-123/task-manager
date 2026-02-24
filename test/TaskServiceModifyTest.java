
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceModifyTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1,"Test",1));
    }

    @Test
    void shouldUpdateTitle() {
        service.updateTitle(1,"Updated");
        assertEquals("Updated", service.getTask(1).getTitle());
    }

    @Test
    void shouldDeleteTask() {
        assertTrue(service.deleteTask(1));
    }

    @Test
    void deleteMissingShouldFail() {
        assertFalse(service.deleteTask(99));
    }
}
