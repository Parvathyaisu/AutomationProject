package testpkg;

import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.FableStreetPagePrgrm;
import utilities.ExcelUtils;

public class FableStreetPageTestPrgrm extends Baseclass{
	@Test(priority=1)
	   public void test() throws InterruptedException 
	      { 
			  FableStreetPagePrgrm fs=new FableStreetPagePrgrm(driver);	
		      fs.account();

	          //Reading  the data from excel file by the specified path	
			
			  String xl="C:\\Users\\parva\\OneDrive\\Documents\\Book3.xlsx";
			  String Sheet="Sheet1";
			
			  int rowcount=ExcelUtils.getRowCount(xl, Sheet);
			
			  for(int i=1;i<=rowcount;i++)
			   {
			          String email=ExcelUtils.getCellValue(xl, Sheet, i, 0);
			          System.out.println("email----"+email);
			
			          String pswd=ExcelUtils.getCellValue(xl, Sheet, i, 1);
			          System.out.println("password----"+pswd);
			
	                  //passing email and password as parameters
			          fs.setvalues1(email,pswd);
	                  //submitting the data by clicking on login button
			          fs.clickLoginBtn();
			          Thread.sleep(2000);
			   }
	      }

	@Test(priority=2)
	   public void test2() throws InterruptedException 
	     { 
		    FableStreetPagePrgrm fp=new FableStreetPagePrgrm(driver);	
			         
			          fp.homepage();
			          Thread.sleep(3000);
			          fp.scrolldwn();
			          fp.addtocart();
			          Thread.sleep(2000);
			          fp.page();
			          fp.setvalues2("Tops");
			          Thread.sleep(2000);
			          fp.nextpage();
			          fp.menusclick();
			          fp.titleverification();
			          fp.logoDisplay();
			          fp.test();
			          Thread.sleep(2000);
			          fp.wishlist();
			          fp.continueshopping();
			          fp.logout();
	      
	      }
}
