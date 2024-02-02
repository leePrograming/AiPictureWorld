package com.example.demo.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("# BeforeAll Annotation 소환 #");
        System.out.println();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("# afterAll Annotation 소환 #");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("# beforeEach 소환 #");
        System.out.println();
    }

    @AfterEach
    void afterEach(){
        System.out.println("# afterEach 소환 #");
        System.out.println();
    }

    @Test
    void test1(){
        System.out.println("# test1 시작 #");
        System.out.println();
    }

    @Test
    @DisplayName("test Case2~")
    void test2(){
        System.out.println("# test2 시작 #");
        System.out.println();
    }

    @Test
    @Disabled
        // 테스트를 실행하지 않게 설정하는 어노테이션
    void test3(){
        System.out.println("# test3 시작 #");
        System.out.println();
    }
}
