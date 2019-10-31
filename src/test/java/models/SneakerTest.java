package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SneakerTest {
    @Test
    public void setNameTest() {
        // given
        String expected = "Nike";

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setName(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getName());
    }
}
