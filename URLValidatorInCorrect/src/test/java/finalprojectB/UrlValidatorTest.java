
package finalprojectB;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest {

	@Test
	public void Test01_Manual_Testing() throws Throwable//Tests known websites 
	{  
		System.out.print("\nTesting websites known to exist\n");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		UrlValidator urlVal2 = new UrlValidator();
		assertTrue(urlVal.isValid("http://www.youtube.com"));
		assertTrue(urlVal.isValid("http://www.reddit.com:65535"));
		assertTrue(urlVal.isValid("ftp://www.spotify.com"));
		assertTrue(urlVal.isValid("http://www.google.com/$23"));
		assertTrue(urlVal.isValid("https://www.amazon.com?action=view"));
		assertTrue(urlVal2.isValid("http://www.youtube.com"));
		assertTrue(urlVal2.isValid("http://www.reddit.com"));
		assertTrue(urlVal2.isValid("http://www.spotify.com"));
		assertTrue(urlVal2.isValid("https://www.google.com"));
		assertTrue(urlVal2.isValid("http://www.amazon.com"));
		assertTrue(urlVal2.isValid("http://www.ebay.com"));
		assertTrue(urlVal2.isValid("http://www.amazon.com"));
		assertTrue(urlVal2.isValid("http://www.ebay.com"));
	}

	@Test
	public void Test02_Manual_Testing() throws Throwable//Tests websites that don't exist
	{     
		System.out.print("\nTesting websites known to NOT exist\n");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		UrlValidator urlVal2 = new UrlValidator();
		assertFalse(urlVal.isValid("345453eb3ay1236456456452"));
		assertFalse(urlVal.isValid("://h.youtube1321354313123.com"));
		assertFalse(urlVal.isValid("6.6.6.6.6.6.6"));
		assertFalse(urlVal.isValid("10.10.10.10"));
		assertFalse(urlVal2.isValid("http://.spotify56456."));
		assertFalse(urlVal.isValid("http://www.google.com/..//file"));
	}

//
	@Test
	public void Test03_Partition_Test() throws Throwable
	{	   
		System.out.print("\nTesting string with improper protocol\n");
		UrlValidator urlVal = new UrlValidator();
		String precomp = "://www.google.com";
		Random rand = new Random();
		for (int i = 0; i < 100000; i++) {
			String protocol = "";
			int pass = 0;
			for (int j = 0; j < (rand.nextInt(8) + 1); j++) {
				char randchar = (char)(rand.nextInt(97) + 1);
				protocol = protocol.concat(String.valueOf(randchar));
			}
			if ((protocol.equals("http")) || (protocol.equals("ftp"))
				|| (protocol.equals("h3t")) || (protocol.equals("https"))){
				pass = 1;
			}
			protocol = protocol.concat(precomp);
			if (pass == 1)
				assertTrue(urlVal.isValid(protocol));
			else
				assertFalse(urlVal.isValid(protocol));  
		}
	}

	@Test
	public void Test04_Partition_Test() throws Throwable
	{	   
		System.out.print("\nTesting string with improper top-level domain\n");
		UrlValidator urlVal = new UrlValidator();
		Random rand = new Random();
		for (int i = 0; i < 100000; i++) {
			String protocol = "";
			String precomp = "http://www.google.";
			int pass = 0;
			for (int j = 0; j < (rand.nextInt(3) + 3); j++) {
				char randchar = (char)(rand.nextInt(97) + 1);
				protocol = protocol.concat(String.valueOf(randchar));
			}
			if ((protocol.equals("com")) || (protocol.equals("org"))
				|| protocol.equals("net")) {
				pass = 1;
			}
			precomp = precomp.concat(protocol);
			if (pass == 1)
				assertTrue(urlVal.isValid(protocol));
			else
				assertFalse(urlVal.isValid(protocol));  
		}
	}

	@Test
	public void Test05_Programming_Test() throws Throwable
	{
		System.out.print("\nTesting random combination of web URLs\n");
		UrlValidator urlVal = new UrlValidator();
		Random rand = new Random();
		for (int i = 0; i < 300000; i++) {

			String test = "";
			int pass;
			int randy = rand.nextInt(4) + 1;
			pass = 1;
			if ((randy == 1) || (randy == 2)) {
				test = "http://";
			}
			if (randy == 3) {
				test = "";
				pass = 0;
			}
			if (randy == 4) {
				test = "FAIL";
				pass = 0;
			}
			randy = rand.nextInt(10) + 1;
			if (randy < 8) {  //valid
				if (randy == 1) {
					if (test.length() > 0)
						test = test.concat("www.google.com");
					else
						test = "www.google.com";
				}
				if (randy == 2) {
					if (test.length() > 0)
						test = test.concat("www.youtube.com");
					else
						test = "www.youtube.com";
				}
				if (randy == 3) {
					if (test.length() > 0)
						test = test.concat("www.bing.com");
					else
						test = "www.bing.com";
				}
				if (randy == 4) {
					if (test.length() > 0)
						test = test.concat("www.yahoo.com");
					else
						test = "www.yahoo.com";
				}
				if (randy == 5) {
					if (test.length() > 0)
						test = test.concat("www.gmail.com");
					else
						test = "www.gmail.com";
				}
				if (randy == 6) {
					if (test.length() > 0)
						test = test.concat("www.github.com");
					else
						test = "www.github.com";
				}
				if (randy == 7) {
					if (test.length() > 0) {
						test = test.concat("www.facebook.com");
					}
					else
						test = "www.facebook.com";
				}
			} 
			else {   //invalid
				pass = 0;
				for (int j = 0; j < randy*2; j++) {
					test = test.concat(Integer.toString(rand.nextInt(79) + 47));
				}
			}
			if (pass == 1) {
				assertTrue(urlVal.isValid(test));
			}
			if (pass == 0) {
				assertFalse(urlVal.isValid(test));
			}
		}
	}
}
