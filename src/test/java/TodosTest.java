import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void falseTestSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask1 = new SimpleTask(6, "лягти спати");
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleTask1);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = new Task[0];
        Task[] result = todos.search("Закрытие");

        assertArrayEquals(expected, result);
    }
    @Test
    public void trueTestSearch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Выкатка"});
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = new Task[2];
        expected[0] = epic;
        expected[1] = meeting;
        Task[] result = todos.search("Выкатка");

        assertArrayEquals(expected, result);
    }
}
