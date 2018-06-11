
package finalprojectB;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest {

   // @Test(timeout = 4000)
   // public UrlValidatorTest(String testName) {
   //    // super(testName);
   //    System.out.print("\n Manual Testing... ");
   // }
//
   @Test(timeout = 4000)
   public void Test01() throws Throwable//Tests known websites 
   {   
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      UrlValidator urlVal2 = new UrlValidator(); //should cause false returns on isValid
      assertTrue(urlVal.isValid("http://www.youtube.com"));
      assertTrue(urlVal.isValid("http://www.reddit.com"));
      assertTrue(urlVal.isValid("http://www.spotify.com"));
      assertTrue(urlVal.isValid("http://www.google.com"));
      assertTrue(urlVal.isValid("http://www.amazon.com"));
      assertTrue(urlVal.isValid("http://www.ebay.com"));
      assertTrue(urlVal2.isValid("http://www.youtube.com"));
      assertTrue(urlVal2.isValid("http://www.reddit.com"));
      assertTrue(urlVal2.isValid("http://www.spotify.com"));
      assertTrue(urlVal2.isValid("http://www.google.com"));
      assertTrue(urlVal2.isValid("http://www.amazon.com"));
      assertTrue(urlVal2.isValid("http://www.ebay.com"));
     
   }

   @Test(timeout = 4000)
   public void Test02() throws Throwable//Tests known websites
   {     
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      UrlValidator urlVal2 = new UrlValidator(); //should cause false returns on isValid
      assertFalse(urlVal.isValid("http://www.342345453eb3ay1236456456452"));
      assertFalse(urlVal.isValid("http://www.youtube1321354313123.com"));
      assertFalse(urlVal.isValid("http://www.reddit12312312324.com"));
      assertFalse(urlVal2.isValid("http://www.spotify56456.com"));
      assertFalse(urlVal2.isValid("http://www.google.com"));
      assertFalse(urlVal2.isValid("http://www.amazon.com"));
      assertFalse(urlVal2.isValid("http://www.ebay.com"));
      // UrlValidator urlVal = new UrlValidator();
      // assertEquals(null, urlVal.isValid());

   }

   @Test(timeout = 4000)
   public void Test03() throws Throwable//Tests known websites
   {   
      // UrlValidator urlVal = new UrlValidator();
      // assertEquals(null, urlVal.isValid());

   }
   
//
   @Test(timeout = 4000)
   public void Test04() throws Throwable//Tests known websites
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   @Test(timeout = 4000)
   public void Test05() throws Throwable//Tests known websites
	{	
    //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   @Test(timeout = 4000)
   public void Test06() throws Throwable//Tests known websites
   {
	   //You can use this function for programming based testing

   }
   


}
