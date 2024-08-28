package examples.dynamic;

import examples.browserstack.DummyScenario1Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestExample {

    @BeforeAll
    public static void setup(){
        System.out.println("setting up the tests");
    }

    @BeforeEach
    public void pre(){
        System.out.println("preprocessing...");
    }

    @TestFactory
    Stream<DynamicNode> dynamicTestsWithContainers() {

        return Stream.of("BACS", "CHAPS", "FASTER")
                .map(paymentType -> dynamicContainer("Container " + paymentType, Stream.of(
                        dynamicTest("create payment type "+paymentType, () -> {
                            System.out.println("creating...");
                        }),
                        dynamicTest("batch payment "+paymentType, () -> System.out.println("batching...")),
                        dynamicTest("authorise payment "+paymentType, () -> System.out.println("authorising..."))
                )));
    }
}
