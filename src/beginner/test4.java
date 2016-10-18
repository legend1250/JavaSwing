package beginner;

public class test4 {
	public static void main(String[] args){
		int a[][] = new int [5][5];
		a[0][0] = 10;
		a[0][1] = 5;
		a[3][3] = 9;
		for(int i = 0 ; i < 5 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void tong(int a, double b){
		double c = a+b;
		System.out.println(c);
	}
}
