/**
 * 
 */
package recursion_practices;

/**
 * @author Vinh - legend1250
 *
 */
public class Recursion_practices02 {

	public static void main(String[] args){
		//System.out.println( f( 4 ) );
		//fb("a");
		//System.out.println( bin ( 1024 ) );
		System.out.println(st("Hello"));
		//fb("");
	}
	
	//homework practices slide PowerPoint of Mr.Nam
	//fibonaci
	static int f(int n){
		if(n == 0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return f(n-1) + f(n-2);
	}
	
	//dec => bin
	static String s ="";
	static String bin(int n){
		if ( n == 0){
			System.out.println(s);
			return "";
		}
		s = String.valueOf(n%2) +s;
		return bin(n/2);
	}
	
	//print aaa aab aac .... ccc
	static void fb(String s){
		if(s.length() >= 3){
			System.out.println(s);
			return; 
		}
		fb(s +"a");
		fb(s +"b");
		fb(s +"c");
	}
	
	static String st (String s){
		
		if(s.length() <= 0){
			return s;
		}
		return s.substring(s.length()-1) + st(s.substring(0, s.length()-1));
	}
}
