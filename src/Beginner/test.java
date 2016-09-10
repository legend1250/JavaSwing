package Beginner;

public class test {
	public static void main(String[] args) {
		String str = "1+2+3+4*5-6*7+9/9+3/3";
		int i,c=1,st;
		String cong[] = new String[100];
		int a = 0,n=0;
		//a= str.split("\\*");
		//a= str.split("\\/");
		boolean firstnum = true;
		for (i = 0 ; i < str.length() ; i++){
			
			if (str.charAt(i) == '+'){
				if (firstnum == false){
					cong[a] = str.substring(n+1, i);
					//System.out.print("a");
				}
				else{
					cong[a] = str.substring(n, i);
					firstnum = false;
				}
				n=i;
				System.out.println(cong[a]);
				a++;
			}
			
		}
	}
}
