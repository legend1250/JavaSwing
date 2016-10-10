package beginner;

public class test {
	public static void main(String[] args) {
		String str = "1+23+69";
		String str2 = "23*53+1231+",str3="";
		int i,c=1,st;
		String cong[] = new String[100];
		int a = 0,n=0;
		//a= str.split("\\*");
		//a= str.split("\\/");
		//i=str.indexOf("+");
		//System.out.println("i: " +i);
		//System.out.println(""+str.substring(str.indexOf("+")+1, str.length()));
		char x = '-';
		char[] m = {'+','-','*','/'};
		for (i = 0 ; i < m.length ; i++){
			if (str2.lastIndexOf(m[i])>0){
			//	str2 = str2.substring(0, str.length()-1)+x;
			}				
		}
		System.out.println(str2.substring(0, str2.length()-1));
	}
}
