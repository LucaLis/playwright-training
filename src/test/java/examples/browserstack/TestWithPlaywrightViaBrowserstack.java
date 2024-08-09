package examples.browserstack;

import com.microsoft.playwright.Page;
import examples.PlaywrightManager;
import org.junit.jupiter.api.BeforeAll;

public interface TestWithPlaywrightViaBrowserstack {

    class SingletonHolder {
        // ThreadLocal withInitial method to create the singleton instance for each thread
        private static final ThreadLocal<PlaywrightViaBrowserstackManager> threadLocalInstance =
                ThreadLocal.withInitial(() -> new PlaywrightViaBrowserstackManager());
    }

    // Provides the global point of access to the singleton instance
    default PlaywrightViaBrowserstackManager getPlaywrightManagerInstance() {
        // Accesses the singleton instance specific to the current thread
        return SingletonHolder.threadLocalInstance.get();
    }

    default Page getPage(){
        return getPlaywrightManagerInstance().getPage();
    }

    @BeforeAll
    default void setup(){
        getPlaywrightManagerInstance().initNewPage();
    }

}
