public class Utils {
    final static String BASE_URL = "https://www.cooppank.ee/kodulaen";
    final static String CHROME_DRIVER_LOCATION = checkPlatform();

    public static String checkPlatform() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "resources/chromedriverForWin/chromedriver.exe";
        } else if (os.contains("mac")) {
            return "resources/chromedriverForMac/chromedriver";
        }
        return "No chromedriver for this platform";
    }
}
