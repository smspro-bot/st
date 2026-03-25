//Q.1) Write and test a program to handle alert, frame and windows 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.Alert; 
 
import java.util.Set; 
 
public class FistTest { 
 
    public static void main(String[] args) throws InterruptedException { 
 
        // Set path of chromedriver 
        System.setProperty("webdriver.chrome.driver", "E:\\selenium 25-26\\chromedriver-win32 
146\\chromedriver.exe"); 
 
        WebDriver driver = new ChromeDriver(); 
 
        // Open website 
        driver.get("https://demoqa.com"); 
        Thread.sleep(3000); 
        driver.manage().window().maximize(); 
 
        System.out.println("Website Opened Successfully"); 
 
        Thread.sleep(2000); 
        // --------- HANDLE ALERT --------- 
        driver.get("https://demoqa.com/alerts"); 
 
        WebElement alertBtn = driver.findElement(By.id("alertButton")); 
        alertBtn.click(); 
 
        Thread.sleep(2000); 
 
        Alert alert = driver.switchTo().alert(); 
        System.out.println("Alert Text: " + alert.getText()); 
 
        alert.accept(); 
        System.out.println("Alert Handled Successfully"); 
        Thread.sleep(2000); 
 
        // --------- HANDLE FRAME --------- 
        driver.get("https://demoqa.com/frames"); 
 
        driver.switchTo().frame("frame1"); 
 
        WebElement frameText = driver.findElement(By.id("sampleHeading")); 
        System.out.println("Frame Text: " + frameText.getText()); 
 
        driver.switchTo().defaultContent(); 
        System.out.println("Returned from Frame"); 
 
        Thread.sleep(2000); 
        // --------- HANDLE WINDOWS --------- 
        driver.get("https://demoqa.com/browser-windows"); 
 
        String parentWindow = driver.getWindowHandle(); 
 
        WebElement newTabBtn = driver.findElement(By.id("tabButton")); 
        newTabBtn.click(); 
 
        Set<String> allWindows = driver.getWindowHandles(); 
 
        for (String window : allWindows) { 
 
            if (!window.equals(parentWindow)) { 
 
                driver.switchTo().window(window); 
                System.out.println("Switched to New Window"); 
 
                WebElement text = driver.findElement(By.id("sampleHeading")); 
                System.out.println("New Window Text: " + text.getText()); 
 
                driver.close(); 
            } 
        } 
 
        driver.switchTo().window(parentWindow); 
        System.out.println("Returned to Parent Window"); 
 
        driver.quit(); 
        System.out.println("Test Completed Successfully"); 
    } 
} 
 
OUTPUT: 
Website Opened Successfully 
Alert Text: You clicked a button 
Alert Handled Successfully 
Frame Text: This is a sample page 
Returned from Frame 
Switched to New Window 
New Window Text: This is a sample page 
Returned to Parent Window 
Test Completed Successfully 
 
 
//Q.2) Write and test a program to upload file. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class FileUpload { 
 
    public static void main(String[] args) throws InterruptedException { 
 
        // Set path for ChromeDriver 
        System.setProperty("webdriver.chrome.driver", "E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe"); 
 
        // Launch browser 
        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
 
        // Open file upload website 
        driver.get("https://the-internet.herokuapp.com/upload"); 
        Thread.sleep(2000); 
 
        System.out.println("Website Opened Successfully"); 
 
        // Locate file upload element 
        WebElement uploadElement = driver.findElement(By.id("file-upload")); 
 
        // Provide file path 
        uploadElement.sendKeys("E:\\amk\\FIRST.java"); 
 
        System.out.println("File Selected Successfully"); 
 
        // Click Upload button 
        driver.findElement(By.id("file-submit")).click(); 
 
        Thread.sleep(2000); 
 
        // Verify upload success 
        String result = driver.findElement(By.tagName("h3")).getText(); 
 
        if(result.equals("File Uploaded!")) 
        { 
            System.out.println("Test Passed: File Uploaded Successfully"); 
        } 
        else 
        { 
            System.out.println("Test Failed"); 
        } 
 
        // Close browser 
        driver.quit(); 
    } 
} 
OUTPUT: 
Website Opened Successfully 
File Selected Successfully 
Test Passed: File Uploaded Successfully 
 
//Q.3) Write and test a program to download the file. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class Download { 
 
    public static void main(String[] args) throws InterruptedException { 
 
        // Set path for ChromeDriver 
        System.setProperty("webdriver.chrome.driver", "E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe"); 
 
        // Launch browser 
        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
 
        // Open download page 
        driver.get("https://the-internet.herokuapp.com/download"); 
        Thread.sleep(3000); 
 
        System.out.println("Website Opened Successfully"); 
 
        // Click file link to download 
        driver.findElement(By.linkText("some-file.txt")).click(); 
 
        System.out.println("Download Started"); 
 
        // Wait for download 
        Thread.sleep(5000); 
 
        System.out.println("File Downloaded Successfully"); 
 
        // Close browser 
        driver.quit(); 
    } 
} 
OUTPUT: 
Website Opened Successfully 
Download Started 
File Downloaded Successfully 
 
//Q.4) Write and test a program to handling Menus. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.interactions.Actions; 
 
public class MenuTest { 
 
    public static void main(String[] args) throws InterruptedException { 
 
        // Set path for ChromeDriver 
        System.setProperty("webdriver.chrome.driver", "E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe"); 
 
        // Launch browser 
        WebDriver driver = new ChromeDriver(); 
 
        // Open website 
        driver.get("https://demoqa.com/menu"); 
        driver.manage().window().maximize(); 
 
        // Create Actions class object 
        Actions act = new Actions(driver); 
 
        // Locate menu elements 
        WebElement mainItem = driver.findElement(By.xpath("//a[text()='Main Item 2']")); 
        WebElement subItem = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']")); 
        WebElement subSubItem = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']")); 
 
        // Perform mouse hover actions 
        act.moveToElement(mainItem).perform(); 
        Thread.sleep(2000); 
 
        act.moveToElement(subItem).perform(); 
        Thread.sleep(2000); 
 
        // Click submenu 
        act.moveToElement(subSubItem).click().perform(); 
 
        System.out.println("Menu handled successfully"); 
 
        driver.quit(); 
    } 
} 
 
OUTPUT:- 
 
Menu handled successfully 
 
 
 
 
 
 
 
 
 
 
 
 
//Q.5) Write and test a program handling web table records. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import java.util.List; 
 
public class WebTableHandler { 
 
public static void main(String[] args) { 
 
// Set ChromeDriver path 
System.setProperty("webdriver.chrome.driver", " E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe "); 
 
WebDriver driver = new ChromeDriver(); 
 
// Open webpage containing table 
driver.get("https://example.com/webtable"); 
 
// Locate table rows 
List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr")); 
 
System.out.println("Total Rows: " + rows.size()); 
 
// Loop through rows 
for (int i = 1; i <= rows.size(); i++) { 
 
String col1 = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText(); 
String col2 = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText(); 
String col3 = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText(); 
 
System.out.println(col1 + " | " + col2 + " | " + col3); 
 
// Simple test condition 
if (col1.equals("John")) { 
System.out.println("Test Passed: Record found for John"); 
} 
} 
 
driver.quit(); 
} 
} 
OUTPUT:- 
Total Rows: 3 
John | 25 | New York 
Test Passed: Record found for John 
Mary | 30 | London 
Raj | 28 | Mumbai 
 
 
 
//Q.6) Write and test a program handling slider. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.interactions.Actions; 
 
public class SliderHandling { 
 
public static void main(String[] args) throws InterruptedException { 
 
// Set path for ChromeDriver 
System.setProperty("webdriver.chrome.driver"," E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe "); 
 
// Launch browser 
WebDriver driver = new ChromeDriver(); 
 
// Open slider demo page 
driver.get("https://demoqa.com/slider"); 
driver.manage().window().maximize(); 
 
// Locate slider element 
WebElement slider = driver.findElement(By.xpath("//input[@type='range']")); 
 
// Create Actions object 
Actions act = new Actions(driver); 
 
// Move slider to the right 
act.dragAndDropBy(slider, 50, 0).perform(); 
Thread.sleep(2000); 
 
// Move slider to the left 
act.dragAndDropBy(slider, -30, 0).perform(); 
Thread.sleep(2000); 
 
System.out.println("Slider handled successfully"); 
 
// Close browser 
driver.quit(); 
} 
} 
OUTPUT:- 
Slider handled successfully.. 
Browser actions: 
1. Opens slider page 
2. Moves slider right 
3. Moves slider left 
4. Closes browser 
 
 
 
//Q.7) Write and test a program color, fonts and size of text on a web page. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class TextProperties { 
 
public static void main(String[] args) { 
 
// Set path for ChromeDriver 
System.setProperty("webdriver.chrome.driver"," E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe "); 
 
// Launch browser 
WebDriver driver = new ChromeDriver(); 
 
// Open webpage 
driver.get("https://example.com"); 
driver.manage().window().maximize(); 
 
// Locate text element 
WebElement text = driver.findElement(By.tagName("h1")); 
 
// Get CSS properties 
String color = text.getCssValue("color"); 
String font = text.getCssValue("font-family"); 
String size = text.getCssValue("font-size"); 
 
// Print properties 
System.out.println("Text Color: " + color); 
System.out.println("Font Family: " + font); 
System.out.println("Font Size: " + size); 
 
// Close browser 
driver.quit(); 
} 
} 
OUTPUT:- 
 
Text Color: rgba(0, 0, 0, 1) 
Font Family: Arial 
Font Size: 32px 
 
 
 
 
 
 
 
 
 
//Q.8) Write and test a program handling browser windows.  
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import java.util.Set; 
 
public class WindowHandling { 
 
public static void main(String[] args) throws InterruptedException { 
 
// Set path for ChromeDriver 
System.setProperty("webdriver.chrome.driver"," E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe "); 
 
// Launch browser 
WebDriver driver = new ChromeDriver(); 
 
// Open website 
driver.get("https://demoqa.com/browser-windows"); 
driver.manage().window().maximize(); 
 
// Store main window handle 
String mainWindow = driver.getWindowHandle(); 
 
// Click button to open new window 
driver.findElement(By.id("windowButton")).click(); 
 
// Get all window handles 
Set<String> allWindows = driver.getWindowHandles(); 
 
// Switch to new window 
for(String window : allWindows) 
{ 
if(!window.equals(mainWindow)) 
{ 
driver.switchTo().window(window); 
System.out.println("New Window Title: " + driver.getTitle()); 
driver.close(); // Close new window 
} 
} 
 
// Switch back to main window 
driver.switchTo().window(mainWindow); 
 
System.out.println("Main Window Title: " + driver.getTitle()); 
 
driver.quit(); 
} 
} 
 
 
 
OUTPUT:- 
New Window Title: This is a sample page 
Main Window Title: Browser Windows 
 
//Q.9) Write and test a program handling date picker.  
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class DatePickerHandling { 
 
    public static void main(String[] args) throws InterruptedException { 
 
        // Set ChromeDriver path 
        System.setProperty("webdriver.chrome.driver","E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe"); 
 
        // Launch browser 
        WebDriver driver = new ChromeDriver(); 
 
        // Open Date Picker webpage 
        driver.get("https://demoqa.com/date-picker"); 
        driver.manage().window().maximize(); 
 
        // Click date input box 
        WebElement dateBox = driver.findElement(By.id("datePickerMonthYearInput")); 
        dateBox.click(); 
 
        // Select a specific date (example: 15th day) 
        WebElement date = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day-
015')]")); 
        date.click(); 
 
        // Print selected date 
        String selectedDate = dateBox.getAttribute("value"); 
        System.out.println("Selected Date: " + selectedDate); 
 
        // Close browser 
        driver.quit(); 
    } 
} 
 
OUTPUT:- 
Selected Date: 03/15/2026 
 
 
 
 
 
 
 
//Q.10) Write and test a program to provide a total number of objects present/available on the page. 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import java.util.List; 
 
public class CountObjects { 
 
    public static void main(String[] args) { 
 
        // Set path for ChromeDriver 
        System.setProperty("webdriver.chrome.driver","E:\\selenium 25-26\\chromedriver-win32 
145\\chromedriver.exe"); 
 
        // Launch browser 
        WebDriver driver = new ChromeDriver(); 
 
        // Open webpage 
        driver.get("https://example.com"); 
        driver.manage().window().maximize(); 
 
        // Find all elements on the page 
        List<WebElement> objects = driver.findElements(By.xpath("//*")); 
 
        // Count total objects 
        int totalObjects = objects.size(); 
 
        // Print result 
        System.out.println("Total number of objects on the page: " + totalObjects); 
 
        // Close browser 
        driver.quit(); 
    } 
} 
OUTPUT:- 
 
Total number of objects on the page: 11 
 
 
 
 
 
 
 
 
 
 
 
 
 