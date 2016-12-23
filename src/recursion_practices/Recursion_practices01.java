/**
 * 
 */
package recursion_practices;

/**
 * @author Vinh - legend1250
 *
 */
public class Recursion_practices01 {

	public static void main(String[] args){
		int[] a = {51,2,-3,4};
		
		//System.out.println(ToanSoDuong(a,a.length));
		//System.out.println(max(a,a.length));
		System.out.println(dd(4));
	}
	
	// 2^n
	static int P (int n){
		if(n <= 0){
			return 1;
		}
		return P(n-1) * 2;
	}
	
	// tim so duong
	static boolean ToanSoDuong (int a[], int n) {  
		if (n <= 1){
			return (a[0] > 0); 
		}
			  
		return ToanSoDuong(a,n-1) && (a[n-1] > 0); 
	}
	
	
	// can cua R + (can R-1 + (can R-....))
	static double R(int n){
		if(n<= 1){
			return 1;
		}
		return Math.sqrt(n+R(n-1));
	}
	
	// == tim so le
	static boolean sole(int n){
		if(n<10){
			return n%2 == 1;
		}
		int sodonvi = n/10;
		return (sodonvi%2 == 1) && sole(n/10);
	}
	
	// == max of 1-dimension array
	static int max(int[] a, int n){
		if( n <= 1){
			return a[0];
		}
		int m = max(a,n-1);
		if(a[n-1] > m){
			return a[n-1];
		}
		return m;
	}
	
	// == 1^2 + 2^2 + 3^2 + ... n^2
	static int nn(int n){
		if(n<= 1){
			return 1;
		}
		return n*n + nn(n-1);
	}
	
	//== 1/2 + 1/4 + 1/8 + ... 1/2^n
	static int a(int n){
		if(n<=0){
			return 1;
		}
		
		return 2 * a(n-1);
	}
	
	static double dd(int n){
		if(n <= 1){
			return 0.5;
		}
		double d = a(n);
		return (double)1/d + dd(n-1);
	}
}
