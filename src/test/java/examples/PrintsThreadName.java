package examples;

import org.junit.jupiter.api.BeforeAll;

public interface PrintsThreadName {

    @BeforeAll
    default void printThreadName(){
        System.out.println("Running test in thread: "+Thread.currentThread().getName());
    }

}
