package examples.browserstack;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import org.junit.platform.commons.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

public class PlaywrightViaBrowserstackManager {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    public PlaywrightViaBrowserstackManager() {
        System.out.println("Initialization of Playwright via Browserstack Manager by thread: "+Thread.currentThread().getName()+" - should happen only once per thread!");
        playwright = Playwright.create();

        BrowserType chromium = playwright.chromium();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("browser","chrome");
        jsonObject.addProperty("browser_version","latest");
        jsonObject.addProperty("os","osx");
        jsonObject.addProperty("os_version","catalina");
        jsonObject.addProperty("browserstack.networkLogs", true);
        jsonObject.addProperty("browserstack.local", true);
        jsonObject.addProperty("browserstack.console", "errors");
        jsonObject.addProperty("browserstack.username", "ukaszlis_sqFPbW");
        jsonObject.addProperty("browserstack.accessKey", "u87sXs8fxwUPArpPdJ58");

        // names of session and build etc
        jsonObject.addProperty("project", "playwright-training");
        jsonObject.addProperty("build", StringUtils.isNotBlank(System.getenv("COMPUTERNAME"))?System.getenv("COMPUTERNAME"):System.getenv("HOSTNAME")+" PID: "+ProcessHandle.current().pid());

        // Adding playwright arguments here
        JsonArray arguments = new JsonArray();
        arguments.add("--disable-print-preview");
        jsonObject.add("args", arguments);
        String caps = null;
        try {
            caps = URLEncoder.encode(jsonObject.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to encode capabilities: ",e);
        }
        String ws_endpoint = "wss://cdp.browserstack.com/playwright?caps=" + caps;
        browser = chromium.connect(ws_endpoint);

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
