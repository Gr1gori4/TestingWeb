package org.example.lesson4;
import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.beans.Introspector;
import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssertAssumTest {

    Boolean myBoolen = true;
    Integer myInteger = 100;
    String myString = "str";

    @Test
    void notAtEST() {
        System.out.println("Это не тест");
    }

    @Test
    void test() {
        assertTrue(myBoolen, "He true");
        assertFalse(!myBoolen, "He False");
        assertEquals(100, myInteger.intValue(), "He 100");
        assertEquals("str", myString, "Другое значение переменной myString");
        Assertions.assertSame(myString, myString);
        Assertions.assertNotNull(myInteger);
    }

    @Test
    void exec() throws InterruptedException {
//        Assertions.assertTimeout(ofMillis(10),()->{
//            Thread.sleep(200);
//            return "result";
//        });

        Assertions.assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            Thread.sleep(200);
            return "result";
        });
    }

    @Test
    void testExpeption() {
        Assertions.assertThrows(NullPointerException.class, () -> getException(), "нет исключения");

        Assertions.assertThrows(IllegalAccessException.class, () -> {
            Integer.parseInt("One");
        });
    }

    private String getException() throws NullPointerException
    {
        if(myBoolen) throw new NullPointerException();
        return "rezult";
    }

    @Test
    void allways()
    {
        Assertions.fail("Z");
    }

    @Test
    void assume()
    {
        assumeTrue(5>10);
        assertEquals(5+2,7);
    }
    @Test
    void getAll()
    {
        Assertions.assertAll(
                ()->assertTrue(myBoolen),
                ()->assertFalse(!myBoolen)
        );
    }

}
