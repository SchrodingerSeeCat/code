import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/*
* 获取当前窗口运行的活动名和包名
* adb shell dumpsys window | findstr mCurrentFocus
* */
public class Test {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //手机类型或模拟器类型
        capabilities.setCapability("deviceName", "Android Emulator");
        //自动化测试引擎
        capabilities.setCapability("automationName", "Appium");
        //手机操作系统iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");
        //手机操作系统版本号
        capabilities.setCapability("platformVersion", "6.0.1");
        //app包名
        capabilities.setCapability("appPackage", "com.newcapec.mobile.ncp");
        //app中启动的 Activity名称
        capabilities.setCapability("appActivity", "com.wanxiao.basebusiness.activity.SplashActivity");

        AndroidDriver<WebElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // 进入启动界面
        WebElement right = findElementById(driver, "btn_right");
        if(right != null) {
            right.click();
            System.out.println(right);
        }
//        driver.quit();
    }

    public static WebElement findElementById(AndroidDriver<WebElement> driver, String id) {
        WebElement element = null;
        try {
            element = driver.findElementById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            return element;
        }
    }
}
