package org.example.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppLesson4Test
{

    //static Logger logger = LoggerFactory.getLogger(AppLesson4Test.class);

    Integer repeated=0;

    @Test
    @Disabled("Для демонстрации")
    @Order(1)
    public void simpleTest()
    {
        //logger.info("Инфо");
        //logger.error("Ошибка");
        assertTrue(true);
    }

    @Test
    @DisplayName("Простой тест")
    @Tag("tagTest")
    public void simpleDisableTest()
    {
        assertTrue(true);
    }

    @Test
    @RepeatedTest(10)
    @Tag("tagTest")
    public void repeatedTest()
    {
        repeated++;
        System.out.println("Тестовая строка, номер:"+repeated);
        assertTrue(true);
    }
    @ParameterizedTest
    @ValueSource(strings = {"word1","word2","word3"})
    @Tag("tagTest")
    public void isParameterizedTest(String word)
    {
        System.out.println(word);
    }

    @ParameterizedTest
    @CsvSource({"foo,1","bar,2","'baz,qux',3"})
    //@CsvFileSource(resources="/file.csv")
    void restWithCsvSourse(String first,int second)
    {
        System.out.println(first+second);
    }
    @ParameterizedTest
    @EnumSource(value= TimeUnit.class,names={"DAYS","Hours"})
    void etstWithEnumSoutceIncude(TimeUnit timeunit)
    {
        assertTrue(EnumSet.of(TimeUnit.DAYS,TimeUnit.HOURS).contains((timeunit)));
    }

}
