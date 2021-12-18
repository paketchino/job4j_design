package example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SequenceNumberTest {

    @Test
    public void method() {
        int[] array = new int[]{1, 2, 3, 1, 1};
        SequenceNumber sequenceNumber = new SequenceNumber();
        int[] result = new int[] {1};
        assertThat(sequenceNumber.method(array), is(result));
    }
}