package examples.browserstack;

import examples.PrintsThreadName;
import examples.TestWithPlaywright;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // TODO: verify if this is required by the playwright context / extension - probably not
@TestMethodOrder(MethodOrderer.MethodName.class) 
public class BaseTestViaBS implements PrintsThreadName, TestWithPlaywrightViaBrowserstack {

}
