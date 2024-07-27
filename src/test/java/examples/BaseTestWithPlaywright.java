package examples;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class BaseTestWithPlaywright implements PrintsThreadName, TestWithPlaywright {

}
