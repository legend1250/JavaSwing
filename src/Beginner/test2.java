/**
 * 
 */

package Beginner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Vinh
 *
 */

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date time = new Date(); 
		SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss"); 
		System.out.print(ft.format(time));
		 

		Date dNow = new Date();
		SimpleDateFormat ft2 = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Current Date: " + ft2.format(dNow));
	}

}
