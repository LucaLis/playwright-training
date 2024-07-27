package examples;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeAll;

public interface TestWithPlaywright {

    class SingletonHolder {
        // ThreadLocal withInitial method to create the singleton instance for each thread
        private static final ThreadLocal<PlaywrightManager> threadLocalInstance =
                ThreadLocal.withInitial(() -> new PlaywrightManager());
    }

    // Provides the global point of access to the singleton instance
    default PlaywrightManager getPlaywrightManagerInstance() {
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
