/**
 * 
 */
package beginner;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Vinh - legend1250
 *
 */
public class test6 {
	
	public static void main(String[] args){
		System.out.println(new Date());
		show(new Random().nextInt(10)+1);
	}
	
	public static void show(int seconds){
		Timer tm = new Timer();
		tm.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(new Date());
			}
		}, seconds*1000);
	}
}
