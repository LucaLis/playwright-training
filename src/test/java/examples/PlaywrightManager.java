package examples;

import com.microsoft.playwright.*;

public class PlaywrightManager {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    public PlaywrightManager() {
        System.out.println("Initialization of Playwright Manager by thread: "+Thread.currentThread().getName()+" - should happen only once per thread!");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // close browser during the shutdown of JVM
        // should be actually terminated once we know that there are no more tests for current jUnit worker thread... - otherwise browser stay alive and utilise resources
        Runtime.getRuntime().addShutdownHook(new Thread(()->{browser.close();}));
    }

    public void initNewPage() {
        // at the very start there is no context
        if(browser.contexts().isEmpty()){
            page = browser.newPage();
        } else {
            // context exists so there needs to be a page present too
            final BrowserContext oldContext = browser.contexts().get(0);
            // we can create new context with new page
            page = browser.newPage();
            // and we can close the old one now
            oldContext.close();
        }
    }

    public Page getPage() {
        return page;
    }

}
