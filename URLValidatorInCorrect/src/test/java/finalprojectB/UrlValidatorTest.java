
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
   public void Manual_Test01() throws Throwable//Tests known websites 
   {   
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      UrlValidator urlVal2 = new UrlValidator(); //should cause false returns on isValid
      assertTrue(urlVal.isValid("http://www.youtube.com"));
      assertTrue(urlVal.isValid("http://www.reddit.com:65535"));
      assertTrue(urlVal.isValid("ftp://www.spotify.com"));
      assertTrue(urlVal.isValid("http://www.google.com/$23"));
      assertTrue(urlVal.isValid("http://www.amazon.com?action=view"));
      assertTrue(urlVal.isValid("10.10.10.10"));
      assertFalse(urlVal2.isValid("http://www.youtube.com"));
      assertFalse(urlVal2.isValid("http://www.reddit.com"));
      assertFalse(urlVal2.isValid("http://www.spotify.com"));
      assertFalse(urlVal2.isValid("http://www.google.com"));
      assertFalse(urlVal2.isValid("http://www.amazon.com"));
      assertFalse(urlVal2.isValid("http://www.ebay.com"));
     
   }

   @Test(timeout = 4000)
   public void Manual_Test02() throws Throwable//Tests known websites
   {     
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      UrlValidator urlVal2 = new UrlValidator(); //should cause false returns on isValid
      assertFalse(urlVal.isValid("345453eb3ay1236456456452"));
      assertFalse(urlVal.isValid("://h.youtube1321354313123.com"));
      assertFalse(urlVal.isValid("6.6.6.6.6.6.6"));
      assertFalse(urlVal2.isValid("http://.spotify56456."));
      assertFalse(urlVal.isValid("http://www.google.com/..//file"));
      assertFalse(urlVal2.isValid("http://www.amazon.com"));
      assertFalse(urlVal2.isValid("http://www.ebay.com"));
   }

   @Test(timeout = 4000)
   public void Test03() throws Throwable
   {   
      // UrlValidator urlVal = new UrlValidator();
      // assertEquals(null, urlVal.isValid());

   }
   
//
   @Test(timeout = 4000)
   public void Test04() throws Throwable
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   @Test(timeout = 4000)
   public void Test05() throws Throwable
	{	
    //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   @Test(timeout = 4000)
   public void Test06() throws Throwable
   {
	   //You can use this function for programming based testing

   }
   


}
