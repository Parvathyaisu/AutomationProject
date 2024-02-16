package pagepkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FableStreetPagePrgrm {
WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/div/div[3]/a[1]")
	WebElement accountbutton;  
	
	@FindBy(xpath="//*[@id=\"customer[email]\"]")
	WebElement emailid;
	
	@FindBy(xpath="//*[@id=\"customer[password]\"]")
	WebElement loginpswd;
	
	@FindBy(xpath="//*[@id=\"customer_login\"]/button")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/span/a/img")
	WebElement logo;
	
	@FindBy(xpath="//*[@id=\"shopify-section-footer\"]/footer/div/div/div[1]/div[3]/div/ul/li[2]/a")
	WebElement privacypolicy;
	
	@FindBy(xpath="//*[@id=\"desktop-menu-1\"]/li[3]/a")
	WebElement dresses;
	
	@FindBy(xpath="//*[@id=\"facet-main\"]/product-list/div/product-item[1]/div[2]/div/a")
	WebElement firstdress;
	
	@FindBy(xpath="//*[@id=\"pr-7662091862168\"]/product-variants/div/div[2]/div[1]")
	WebElement dresssize;
	
	@FindBy(xpath="//*[@id=\"AddToCart\"]")
	WebElement addtocart;
	
	@FindBy(xpath="//*[@id=\"mini-cart\"]/div[1]/a")
	WebElement checkoutbestsellers;
	
	@FindBy(xpath="//*[@id=\"search-desktop\"]/input")
	WebElement search;

	@FindBy(xpath="//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/nav/desktop-navigation/ul/li[5]/a")
	WebElement specialprices;
	
	@FindBy(xpath="//*[@id=\"facet-main\"]/product-list/div/product-item[1]/div[1]/div")
	WebElement wishlist;
	
	@FindBy(xpath="//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/div/div[2]/a")
	WebElement wishlistbutton;
	
	@FindBy(xpath="//*[@id=\"swym-component-container\"]/div[2]/div/div/div[2]/button")
	WebElement deletebutton;
	
	@FindBy(xpath="//*[@id=\"shopify-section-footer\"]/footer/div/div/div[1]/div[3]/div/ul/li[5]/a")
	WebElement termsandconditions;
	
	@FindBy(xpath="//*[@id=\"shopify-section-template--15918793523352__main\"]/section/div[1]/div/div/ul/li[3]/a")
	WebElement logout;
	
 public FableStreetPagePrgrm(WebDriver driver) 
    {
	       this.driver=driver;
           PageFactory.initElements(driver,this);
	}
 public void account() 
    {
	       accountbutton.click();
	}
//Login 
 public void setvalues1(String email, String pswd) 
    {
	       emailid.clear();
	       emailid.sendKeys(email);
	       loginpswd.clear();
	       loginpswd.sendKeys(pswd);
	}
 public void clickLoginBtn()
    {
	       login.click();
	}
//Mouse hover
 public void homepage()
   {
	       logo.click();
	       WebElement ele = driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/nav/desktop-navigation/ul/li[1]"));
           Actions action = new Actions(driver);
           action.moveToElement(ele).perform();
           dresses.click();
    }
//scroll down
 public void scrolldwn() 
    {
           JavascriptExecutor js = (JavascriptExecutor) driver;
   	       js.executeScript("window.scrollBy(0,250)", "");
   	 }
//Add to cart
 public void addtocart()
   {
	       firstdress.click();
	       dresssize.click();
           addtocart.click();
   }
 public void page()
   {
           checkoutbestsellers.click();
   }
//search bar
 public void setvalues2(String srch)
   {
	       search.sendKeys(srch);
	       search.sendKeys(Keys.ENTER);
   }
 //Drop-down
 public void nextpage()	
   {
	       specialprices.click(); 
	       Select dropdown=new Select(driver.findElement(By.xpath("//*[@id=\"input-sort\"]")));
	       dropdown.selectByVisibleText("Price, low to high");
   }
//menus 
 public void menusclick() 
   {
		   List<WebElement> menus=driver.findElements(By.xpath("//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/nav/desktop-navigation/ul"));
		   System.out.println("menus are:");
		   for(WebElement title:menus)
	         {
		 		 System.out.println(title.getText());
		 	 }
	}
//Title verification
 public void titleverification()
   {
            String actualtitle=driver.getTitle();
            String title="Special Prices";
            if(title.equals(actualtitle)) 
              {
                    System.out.println("title is same");
              }
            else
              {
                    System.out.println("not same title"); 
              }
   }
//Logo 
 public void logoDisplay()
	 {

             WebElement logo=driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/store-header/div/div[1]/span/a/img"));
             boolean l=logo.isDisplayed() ;
             if (l)
              {
    	           System.out.println("Logo is displayed"); 
              }
             else 
              {
    	           System.out.println("Logo is not displayed");
              }
	 }
//Response code
 public void test()
    {
             String link="https://www.fablestreet.com/";
             try
              {
	              URL u=new URL(link);
	              HttpURLConnection conn=(HttpURLConnection)u.openConnection();
	              int code=conn.getResponseCode();
	 
	              if(code==200) 
	               {
		               System.out.println("Response code is 200");
	               }
	              else
	               {
		               System.out.println("Response code is not 200");
	               }
                }

            catch(Exception e)
             {
	   
             }
     }
//wishlist
 public void wishlist()
  {
		    wishlist.click();     
		    wishlistbutton.click();
  } 
 public void continueshopping()  
  {
	       deletebutton.click();	
	       logo.click();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,500)", "");
  }
//Logout
 public void logout()     
  {
	       accountbutton.click();
	       logout.click();
  }
	   	  
	
   
   
   
   
}
