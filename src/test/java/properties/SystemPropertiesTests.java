package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    //Это один из механизмов передать что-то из вне.

    @Test
    void someTest() {
        String value = System.getProperty("value");  //забираем значение value
        System.out.println(value);
        //null
    }

    @Test
    void someTest1() {
        String value = System.getProperty("value","default_value");  //если value нет, забираем дефолтное значение.
        System.out.println(value);
        //default_value
    }

    @Test
    void someTest2() {
        System.setProperty("value", "another_value");
        String value = System.getProperty("value");
        System.out.println(value);
        //another_value
    }

    @Test
    void someTest3() {
        System.setProperty("value", "another_value");
        String value = System.getProperty("value","default_value");
        System.out.println(value);
        //another_value
    }

    //как запустить тест по тегу
    @Test
    @Tag("properties")
    void someTest4() {
        String value = System.getProperty("browse","chrome");
        System.out.println(value);
        //gradle clean properties_tests - но поч запуск через консоль не работает ???
        //chrome
    }

}
