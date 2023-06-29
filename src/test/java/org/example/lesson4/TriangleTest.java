package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {

    @Test
    void test() throws MyException
    {
        DzLesson4 dzLesson4=new DzLesson4();
        Assertions.assertEquals(6, dzLesson4.SquareTriangle(3,4,5));
        Assertions.assertThrows(MyException.class,()->dzLesson4.SquareTriangle(-3,5,6));
        Assertions.assertThrows(MyException.class,()->dzLesson4.SquareTriangle(-3,5,0));
        Assertions.assertThrows(MyException.class,()->dzLesson4.SquareTriangle(1,20,6));

    }
    @ParameterizedTest
    @CsvSource({"4,5,8,8.18","20,25,40,204.54","40,50,80,818.15"})
    void testWithCsvSourse(int a, int b, int c, double result) throws MyException
    {
        DzLesson4 dzLesson4=new DzLesson4();
        Assertions.assertEquals(result, dzLesson4.SquareTriangle(a,b,c));
    }
    @ParameterizedTest
    @CsvSource({"4,-5,8,8.18","20,100,40,204.54","40,50,0,818.15"})
    void testWithCsvSourseN(int a, int b, int c, double result) throws MyException
    {
        DzLesson4 dzLesson4=new DzLesson4();
        Assertions.assertThrows(MyException.class,()->dzLesson4.SquareTriangle(a,b,c));
    }
}
