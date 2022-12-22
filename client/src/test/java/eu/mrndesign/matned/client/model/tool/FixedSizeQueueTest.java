package eu.mrndesign.matned.client.model.tool;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeQueueTest {

    @ParameterizedTest
    @CsvSource({
            "3, 13, 1, 6, 9",
            "12, 444, 10, 60, 45",
            "100000, 12, 3455, 356, 333",
            "1, 44, 0, 44, 44",
            "45, 67, 35, 444, 8797",
            "300, 287, 1, 345, 779",
            "13, 0, 10, 45, 0"
    })
    void Should_KeepGivenElementsSize_WhenAddingElements(int queueSize, int first, int secondIndex, int second, int last) {
        FixedSizeQueue<Integer> queue = new FixedSizeQueue<>(queueSize);

        for (int i = 0; i < secondIndex; i++) {
            queue.offer(first);
        }
        for (int i = secondIndex; i < queueSize - 1; i++) {
            queue.offer(second);
        }
        queue.offer(last);

        assertEquals(first, queue.peek());

        for (int i = 0; i < secondIndex; i++) {
            queue.offer(null);
        }

        assertEquals(second, queue.peek());

        for (int i = secondIndex; i < queueSize - 1; i++) {
            queue.offer(null);
        }

        assertEquals(last, queue.peek());
        queue.offer(null);
        assertNull(queue.peek());

    }

    @ParameterizedTest
    @CsvSource({"10", "100", "233434"})
    void ShouldReturnNull_WhenPeekAndNoElementsInQueue(int size) {
        FixedSizeQueue<Integer> queue = new FixedSizeQueue<>(size);

        assertNull(queue.peek());
    }

    @ParameterizedTest
    @CsvSource({
            "12, 4, test",
            "312, 45, test",
            "124004, 66600, test",
            "820000, 32000, test"
    })
    void ShouldReturnTrueIfFound_WhenQueueContainsCasted(int size, int numIndex, String num) {
        FixedSizeQueue<String> queue = new FixedSizeQueue<>(size);

        for (int i = 0; i < numIndex; i++) {
            queue.offer(null);
        }
        queue.offer(num);

        assertTrue(queue.contains(num));
    }

    @ParameterizedTest
    @CsvSource({
            "12",
            "312",
            "124004",
            "820000"
    })
    void ShouldReturnFalseIfNotFound_WhenQueueNotContainsCasted(int size) {
        FixedSizeQueue<String> queue = new FixedSizeQueue<>(size);
        assertFalse(queue.contains("Test"));
    }

    @ParameterizedTest
    @CsvSource({
            "12",
            "312",
            "124004",
            "820000"
    })
    void ShouldReturnCorrectValueWhenPull_WhenQueueNotFull(int size) {
        FixedSizeQueue<String> queue = new FixedSizeQueue<>(size);
        queue.offer("test");
        queue.offer("test1");
        queue.offer("test2");
        queue.offer("test3");
        assertEquals("test", queue.peek());
        assertTrue(queue.contains("test3"));
    }






}