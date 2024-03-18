package org.web.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

/**
 * Order of execution:
 *
 * @BeforeAll
 * @BeforeEach
 * @Test
 * @AfterEach
 * @BeforeEach
 * @Test
 * @AfterEach
 * @BeforeEach
 * @Test
 * @AfterEach
 * @AfterAll
 */

public class MySimpleTest extends AbstractTest {
//    @BeforeEach
//    public void beforeTest() {
//        System.out.println(">");
//    }
//
//    @AfterEach
//    public void afterTest(){
//        System.out.println("<");
//    }

    @Test
    public void smth() {
        System.out.println("my simple test 1");
    }

    //mySrouce > for each > smth2(mySource[0],mySource[1])
    @ParameterizedTest
    @MethodSource("mySource")
    public void smth2(String pwd, String errorMessage) {
        System.out.println("When i set password to " + pwd);
        System.out.println("Then i see error message " + errorMessage);
    }

    public static Stream<Arguments> mySource() {
        return Stream.of(
                Arguments.of("pwd1", "msg1"),
                Arguments.of("pwd2", "msg2", "err!"),
                Arguments.of("pwd3", "msg3"),
                Arguments.of("pwd4", "msg4"),
                Arguments.of("pwd5", "msg5"),
                Arguments.of("pwd6", "msg6")
        );
    }
}
