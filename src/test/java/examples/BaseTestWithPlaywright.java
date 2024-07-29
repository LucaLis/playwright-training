package examples;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // TODO: verify if this is required by the playwright context / extension - probably not
@TestMethodOrder(MethodOrderer.MethodName.class) 
public class BaseTestWithPlaywright implements PrintsThreadName, TestWithPlaywright {

}
