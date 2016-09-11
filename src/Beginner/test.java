package Beginner;

public class test {
	public static void main(String[] args) {
		String str = "1+23";
		int i,c=1,st;
		String cong[] = new String[100];
		int a = 0,n=0;
		//a= str.split("\\*");
		//a= str.split("\\/");
		i=str.indexOf("+");
		System.out.println("i: " +i);
		System.out.println(""+str.substring(str.indexOf("+")+1, str.length()));
	}
}
