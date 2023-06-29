package org.example.lesson4;

import org.junit.jupiter.api.*;

public class LFTest {

    static Integer myTestINn = 0;

    @BeforeAll
    static void init() {
        myTestINn++;
        System.out.println("Запускаем до всех тестов " + myTestINn);
    }

    @BeforeEach
    void initTest() {
        myTestINn++;
        System.out.println("Запускаем для каждого теста " + myTestINn);
    }

    @AfterEach
    void afterTest() {
        myTestINn++;
        System.out.println("Запускаем после каждого теста " + myTestINn);
    }

    @AfterAll
    static void close() {
        myTestINn++;
        System.out.println("Запускаем в конце " + myTestINn);
    }

    @Test
    void test1()
    {
        myTestINn++;
        System.out.println("Запускаем первый тест " + myTestINn);
    }

    @Test
    void test2()
    {
        myTestINn++;
        System.out.println("Запускаем второй тест " + myTestINn);
    }
    @Test
    @RepeatedTest(3)
    void test3()
    {
        myTestINn++;
        System.out.println("Запускаем третий тест " + myTestINn);
    }

}
