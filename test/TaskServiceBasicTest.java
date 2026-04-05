
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceBasicTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
    }

    @Test
    void shouldAddTask() {
        service.addTask(new Task(1, "Study", 2));
        assertNotNull(service.getTask(1));
    }

    @Test
    void shouldGetTaskById() {
        service.addTask(new Task(2, "Code", 1));
        assertEquals("Code", service.getTask(2).getTitle());
    }

    @Test
    void shouldReturnAllTasks() {
        service.addTask(new Task(1, "A", 1));
        service.addTask(new Task(2, "B", 2));
        assertEquals(2, service.getAllTasks().size());
    }

    @Test
    void shouldNotAllowDuplicateTaskIds() {
        service.addTask(new Task(1, "Study", 2));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task(1, "Duplicate", 3));
        });
        assertEquals("Task with this ID already exists", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullTask() {
        assertThrows(NullPointerException.class, () -> service.addTask(null));
    }

    @Test
    void shouldHaveValidTaskAttributes() {
        Task task = new Task(1, "Study", 2);
        service.addTask(task);
        Task saved = service.getTask(1);

        assertTrue(saved.getId() > 0);
        assertNotNull(saved.getTitle());
        assertFalse(saved.getTitle().isEmpty());
        assertTrue(saved.getPriority() >= 1 && saved.getPriority() <= 5);
    }

    @Test
    void shouldReturnEmptyListWhenNoTasks() {
        assertTrue(service.getAllTasks().isEmpty());
    }

    @Test
    void shouldDeleteTask() {
        service.addTask(new Task(1, "Study", 2));
        service.deleteTask(1);
        assertNull(service.getTask(1));
    }

    @Test
    void shouldUpdateTask() {
        service.addTask(new Task(1, "Study", 2));
        Task updatedTask = new Task(1, "Study Hard", 3);
        service.updateTask(updatedTask);

        Task saved = service.getTask(1);
        assertEquals("Study Hard", saved.getTitle());
        assertEquals(3, saved.getPriority());
    }
}

