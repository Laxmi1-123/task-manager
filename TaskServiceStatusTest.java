import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TaskServiceStatusTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1, "Study", 2));
    }

    // Normal case
    @Test
    void shouldMarkTaskDone() {
        boolean result = service.markDone(1);
        assertTrue(result);
        assertTrue(service.getTask(1).isDone());
    }

    // Invalid ID
    @Test
    void markDoneOnInvalidTaskShouldReturnFalse() {
        assertFalse(service.markDone(99));
    }

    // Default state
    @Test
    void newTaskShouldBePending() {
        assertFalse(service.getTask(1).isDone());
    }

    // Re-marking same task
    @Test
    void markingAlreadyDoneTaskShouldStillBeDone() {
        service.markDone(1);
        service.markDone(1);
        assertTrue(service.getTask(1).isDone());
    }

    // Multiple tasks
    @Test
    void markingOneTaskShouldNotAffectOthers() {
        service.addTask(new Task(2, "Code", 1));
        service.markDone(1);

        assertTrue(service.getTask(1).isDone());
        assertFalse(service.getTask(2).isDone());
    }

    // Completed tasks list
    @Test
    void shouldReturnCompletedTasksAfterMarkDone() {
        service.markDone(1);
        assertEquals(1, service.getCompletedTasks().size());
    }

    // Initially empty
    @Test
    void completedTasksShouldBeEmptyInitially() {
        assertEquals(0, service.getCompletedTasks().size());
    }

    // Multiple completed
    @Test
    void shouldHandleMultipleCompletedTasks() {
        service.addTask(new Task(2, "Code", 1));
        service.addTask(new Task(3, "Play", 3));

        service.markDone(1);
        service.markDone(2);

        assertEquals(2, service.getCompletedTasks().size());
    }
}