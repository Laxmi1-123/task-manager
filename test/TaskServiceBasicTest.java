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
        service.addTask(new Task(1,"Study",2));
        assertNotNull(service.getTask(1));
    }

    @Test
    void shouldGetTaskById() {
        service.addTask(new Task(2,"Code",1));
        assertEquals("Code", service.getTask(2).getTitle());
    }

    @Test
    void shouldReturnAllTasks() {
        service.addTask(new Task(1,"A",1));
        service.addTask(new Task(2,"B",2));
        assertEquals(2, service.getAllTasks().size());
    }
}