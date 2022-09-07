package genericLibrary;

import java.util.Random;

/**
 * this class contains generic methods related to java like generating
 * random numbers, getting date
 * @author vineeth konge
 *
 */
public class JavaLibrary {
	
	/**
	 * this method will generate the random number and returns it to the caller
	 * for every execution
	 * @return
	 */
	public int getRandomNumber() 
	{
		
		Random ran = new Random();
		 return ran.nextInt(500);
	}

}
