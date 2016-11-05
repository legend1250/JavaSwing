package beginner;

public class test5 {
	public static void main(String[] args){
		int num = 54963;
		int nBin = num;
		int nOct = num;
		int nDec = num;
		int nHex = num;
		
		String 	sBin = "1100101111011",
				sOct = "6251",
				sHexx = "CA9";
		
		int []nHexx = {10,11,12,13,14,15};
		
		String 	sProgrammerBin = "",
				sProgrammerOct = "",
				sProgrammerDec = "",
				sProgrammerHex = "";
		
		String []sHex = {"A","B","C","D","E","F"};
		
		while(nBin>0){
			sProgrammerBin = nBin%2 + sProgrammerBin;
			nBin /=2;
		}
		
		while(nOct>0){
			sProgrammerOct = nOct%8 + sProgrammerOct;
			nOct /=8;
		}
		
		while(nHex>0){
			if(nHex%16 >= 10){
				sProgrammerHex = sHex[nHex%16-10] + sProgrammerHex;
			}
			else{
				sProgrammerHex = nHex%16 + sProgrammerHex;
			}
			nHex /=16;
		}
		
		int result = 0 ;
		for(int i = 0 ; i < sHexx.length() ; i++){
			if(sHexx.charAt(i) >= 65){
				result += Math.pow(16,sHexx.length()-i-1) * nHexx[(sHexx.charAt(i)-65)];
			}
			else{
				result += Math.pow(16,sHexx.length()-i-1) * (sHexx.charAt(i)-48);
			}
			
		}
		System.out.println(result);
	}
}
