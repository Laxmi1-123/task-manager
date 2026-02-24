
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceStatusTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1,"Task",1));
    }

    @Test
    void shouldMarkDone() {
        service.markDone(1);
        assertTrue(service.getTask(1).isDone());
    }

    @Test
    void newTaskDefaultTodo() {
        Task t = new Task(2,"New",1);
        assertFalse(t.isDone());
    }

    @Test
    void emptyTitleThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task(3,"",1));
    }
}