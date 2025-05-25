package Mb_Search_Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mb_Search.Homepage;
import Mb_Search.Mb_ldp;
import Mb_Search.Mb_srp;
import Mb_Search.magichome_srp;
import mbsearch.base.TestBase;

public class magichomeSrp_Test extends TestBase {
	
	Homepage homepage;
	Mb_srp mbsrp;
	Mb_ldp mbldp;
	magichome_srp magicSrp;
	
	public magichomeSrp_Test()
	{
		super();
	}
	

	@BeforeMethod
	public void setup() throws Exception {
		
		initilization();
		//homepage = new Homepage();
		mbsrp = new  Mb_srp();
		mbldp = new  Mb_ldp();
		magicSrp=  new  magichome_srp();
		driver.get(prop.getProperty("magicsrp_url")); 
		
		//homepage.search();		
	}
	 
	
	@Test(priority=1)
	public void magicSrp() throws InterruptedException
	{
		magicSrp.searchcount();		
		magicSrp.Project_namevalidation();
		magicSrp.search();
		magicSrp.Project_namevalidation();
		magicSrp.Srpcard();
		
		
		
	}

}
