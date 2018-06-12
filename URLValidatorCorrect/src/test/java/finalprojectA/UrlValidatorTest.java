
package finalprojectA;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest {

	@Test
	public void Test01_Manual_Testing() throws Throwable   //Tests known websites 
	{  
		System.out.print("\nTesting websites known to exist\n");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	//testing constructor
		UrlValidator urlVal2 = new UrlValidator();	//testing constructor
		long digit = 22222222;
		RegexValidator val = null;
		UrlValidator urlVal3 = new UrlValidator(0);	//testing constructor
		UrlValidator urlVal4 = new UrlValidator(val, 0);	//testing constructor
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
	public void Test02_Manual_Testing() throws Throwable   //Tests websites that don't exist
	{     
		System.out.print("\nTesting websites known to NOT exist\n");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);	//testing constructor
		UrlValidator urlVal2 = new UrlValidator();	//testing constructor
		assertFalse(urlVal.isValid(null));
		assertFalse(urlVal.isValid("youtube.com/http/.39org"));
		assertFalse(urlVal.isValid("//localfiletest32432424.org"));
		assertFalse(urlVal.isValid("345453eb3ay1236456456452"));
		assertFalse(urlVal.isValid("://h.youtube1321354313123.com"));
		assertFalse(urlVal.isValid("6.6.6.6.6.6.6"));
		assertFalse(urlVal.isValid("10.10.10.10"));
		assertFalse(urlVal2.isValid("http://.spotify56456."));
		assertFalse(urlVal.isValid("http://www.google.com/..//file"));
	}

//
	@Test
	public void Test03_Partition_Test() throws Throwable   //tests protocol
	{	   
		System.out.print("\nTesting string with improper protocol\n");
		UrlValidator urlVal = new UrlValidator();	//testing constructor
		String precomp = "://www.google.com";
		Random rand = new Random();
		for (int i = 0; i < 100000; i++) {	//long loop
			String protocol = "";	//clears buffer
			int pass = 0;	//clears buffer
			for (int j = 0; j < (rand.nextInt(8) + 1); j++) {	//gets size of protocol
				char randchar = (char)(rand.nextInt(97) + 1);	//generates protocol
				protocol = protocol.concat(String.valueOf(randchar));
			}
			if ((protocol.equals("http")) || (protocol.equals("ftp"))	//if protocol is valid
				|| (protocol.equals("h3t")) || (protocol.equals("https"))){
				pass = 1;
			}
			protocol = protocol.concat(precomp);
			if (pass == 1)
				assertTrue(urlVal.isValid(protocol));	//should be true
			else
				assertFalse(urlVal.isValid(protocol));  //should be false
		}
	}

	@Test
	public void Test04_Partition_Test() throws Throwable   //tests top-level domain
	{	   
		System.out.print("\nTesting string with improper top-level domain\n");
		UrlValidator urlVal = new UrlValidator();	//testing constructor
		Random rand = new Random();
		for (int i = 0; i < 100000; i++) {	//long loop
			String protocol = "";	//clears buffer
			String precomp = "http://www.google.";	//clears buffer
			int pass = 0;
			for (int j = 0; j < (rand.nextInt(3) + 3); j++) {	//small buffer for top-level domain
				char randchar = (char)(rand.nextInt(97) + 1);
				protocol = protocol.concat(String.valueOf(randchar));	//generates tl domain
			}
			if ((protocol.equals("com")) || (protocol.equals("org"))	//known valid input
				|| protocol.equals("net")) {
				pass = 1;
			}
			precomp = precomp.concat(protocol);
			if (pass == 1)
				assertTrue(urlVal.isValid(protocol));	//should be true
			else
				assertFalse(urlVal.isValid(protocol));  //should be false
		}
	}

	@Test
	public void Test05_Programming_Test() throws Throwable   //tests generated URLs
	{
		System.out.print("\nTesting random combination of web URLs\n");
		UrlValidator urlVal = new UrlValidator();	//testing constructor
		Random rand = new Random();
		for (int i = 0; i < 300000; i++) {	//long loop
			String test = "";
			int pass;
			int randy = rand.nextInt(4) + 1;
			pass = 1;
			if ((randy == 1) || (randy == 2)) {	//sets http
				test = "http://";
			}
			if (randy == 3) {	//sets empty
				test = "";
				pass = 0;
			}
			if (randy == 4) {	//sets error
				test = "FAIL";
				pass = 0;
			}
			randy = rand.nextInt(10) + 1;
			if (randy < 8) {  //valid, gives known domain name
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
				for (int j = 0; j < randy*2; j++) {	//adds random to domain
					test = test.concat(Integer.toString(rand.nextInt(79) + 47));
				}
			}
			if (pass == 1) {	
				assertTrue(urlVal.isValid(test));	//should be true
			}
			if (pass == 0) {
				assertFalse(urlVal.isValid(test));	//should be false
			}
		}
	}
}
