package beginner;

public class test5 {
	
	static int n = 12345678;
	
	public static void main(String[] args){
		String s = Integer.toString(n);
		int l = s.length();
		int arr[] = new int [5];
		
		for(int i = 0 ; i < l/3; i++){
			arr[i] = Integer.parseInt(s.substring(i*3, i*3+3));
			System.out.println(arr[i]);
		}
		
		
	}
}
