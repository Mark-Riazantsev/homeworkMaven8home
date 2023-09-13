import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskTest {
@Test
public void falseMatchesSimpleTask() {
    SimpleTask simpleTask = new SimpleTask(123, "Сделать дз");

    boolean actual = simpleTask.matches("Работа");
    boolean expected = false;

    assertEquals(expected, actual);
}
    @Test
    public void MatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(123, "Сделать дз");

        boolean actual = simpleTask.matches("дз");
        boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    public void falseMatchesMeeting() {
        Meeting meeting = new Meeting(123, "Сделать дз", "Курсы", "На следующей недели");

        boolean actual = meeting.matches("работа");
        boolean expected = false;

        assertEquals(expected, actual);
    }
    @Test
    public void MatchesMeeting() {
        Meeting meeting = new Meeting(123, "Сделать дз", "Курсы", "На следующей недели");

        boolean actual = meeting.matches("Курсы");
        boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    public void falseMatchesEpic() {
        Epic epic = new Epic(123, new String[]{"Полить цветы", "Купить хлеб"} );

        boolean actual = epic.matches("Школа");

        boolean expected = false;

        assertEquals(expected, actual);
    }
    @Test
    public void matchesEpic() {
        Epic epic = new Epic(123, new String[]{"Полить цветы", "Купить хлеб"} );

        boolean actual = epic.matches("цвет");

        boolean expected = true;

        assertEquals(expected, actual);
    }
}