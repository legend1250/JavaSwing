package weekyexam.practices;

public class cReadingNumber {
	public static void main(String[] args){
		
		int n = 19989;
		String output = convertN2S(n);
		/*
		int arr[] = new int [4];
		String s = Integer.toString(n);
		int c=0;
		
		for(int i = s.length(); i > 0 ; i-=3){
			int x0 = i;
			int x1 = i-3;
			if(x1 < 0){
				x1=0;
			}
			arr[c] = Integer.parseInt(s.substring(x1, x0));
			c++;
		}
		
		
		String output = "";
		for(int i = 0 ; i < c ; i++){
			String ss00 = "";
		
			for(int j = 0 ; j < Integer.toString(arr[i]).length() ; j++){
				String ss01[] = {"","one","two","three","four","five","six","seven","eight","nine"};
				String ss02[] = {"","one","twenty","thirdty","forty","fifty","sixty","seventy","eighty","ninety"};
				String ss03[] = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
				int n0 = arr[i];
				if(n0 >= 100){
					if(n0%100 >= 20){
						String qw = Integer.toString(n0);
						char a = qw.charAt(j);
						if(j == 0){
							ss00 += ss01[a-48] + " hundred ";
						}
						else if ( j == 1){
							ss00 += ss02[a-48] + " ";
						}
						else if(j == 2){
							ss00 += ss01[a-48] + " ";
						}
					}else if (n0%100 >= 1){
						if(j == 0){
							String qw = Integer.toString(n0);
							char a = qw.charAt(j);
							ss00 += ss01[a-48] + " hundred and ";
						}
						else {
							ss00 +=ss03[(n0%100)-10] + " ";
							break;
						}
					}
					else {
						String qw = Integer.toString(n0);
						char a = qw.charAt(j);
						ss00 += ss01[a-48] + " hundred ";
						break;
					}
				}
				else if(n0 >= 10){
					String qw = Integer.toString(n0);
					char a = qw.charAt(j);
					if(n0%100 >= 20){
						if ( j == 0){
							ss00 += ss02[a-48] + " ";
						}
						else if(j == 1){
							ss00 += ss01[a-48] + " ";
						}
					}else{
						ss00 +=ss03[(n0%100)-10] + " ";
						break;
					}
				}
				else {
					String qw = Integer.toString(n0);
					char a = qw.charAt(j);
					ss00 += ss01[a-48] + " ";
				}
			}
			if(c== 4){
				if(i == 0){
					if(arr[i] > 0){
						output = "thousand " + ss00;
					}
				}
				else if (i==1){
					if(arr[i] > 0){
						output = "million " +ss00 + output;
					}
				}
				else if( i== 2){
					output = "billion " +ss00 + output;
				}
				else if( i == 3){
					output = ss00 + output;
				}
			}
			if(c == 3){
				if(i == 0){
					if(arr[i] > 0){
						output = "thousand " + ss00;
					}
				}
				else if (i==1){
					output = "million " +ss00 + output;
				}
				else if( i== 2){
					output = ss00 + output;
				}
			}
			if(c == 2){
				if(i == 0){
					output = "thousand " + ss00;
				}
				else if (i==1){
					output = ss00 + output;
				}
				
			}
			if(c == 1){
				if(i == 0){
					output = ss00;
				}
			}
				
			
			//output +=ss;
		}
		*/
		System.out.println(output);
		
	}
	
	public static String getS(int n){
		if(n<0){
			return "";
		}
		int arr[] = new int [4];
		String s = Integer.toString(n);
		int c=0;
		
		for(int i = s.length(); i > 0 ; i-=3){
			int x0 = i;
			int x1 = i-3;
			if(x1 < 0){
				x1=0;
			}
			arr[c] = Integer.parseInt(s.substring(x1, x0));
			c++;
		}
		
		
		String output = "";
		for(int i = 0 ; i < c ; i++){
			String ss00 = "";
		
			for(int j = 0 ; j < Integer.toString(arr[i]).length() ; j++){
				String ss01[] = {"","one","two","three","four","five","six","seven","eight","nine"};
				String ss02[] = {"","one","twenty","thirdty","forty","fifty","sixty","seventy","eighty","ninety"};
				String ss03[] = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
				int n0 = arr[i];
				if(n0 >= 100){
					String qw = Integer.toString(n0);
					char a = qw.charAt(j);
					if(n0%100 >= 20){
						if(j == 0){
							ss00 += ss01[a-48] + " hundred ";
						}
						else if ( j == 1){
							ss00 += ss02[a-48] + " ";
						}
						else if(j == 2){
							ss00 += ss01[a-48] + " ";
						}
					}else if (n0%100 >= 1){
						if(j == 0){
							ss00 += ss01[a-48] + " hundred and ";
						}
						else {
							System.err.println("N="+n);
							ss00 +=ss03[(n0%100)-10] + " ";
							break;
						}
					}
					else {
						ss00 += ss01[a-48] + " hundred ";
						break;
					}
				}
				else if(n0 >= 10){
					if(n0%100 >= 20){
						String qw = Integer.toString(n0);
						char a = qw.charAt(j);
						if ( j == 0){
							ss00 += ss02[a-48] + " ";
						}
						else if(j == 1){
							ss00 += ss01[a-48] + " ";
						}
					}else{
						ss00 +=ss03[(n0%100)-10] + " ";
						break;
					}
				}
				else {
					String qw = Integer.toString(n0);
					char a = qw.charAt(j);
					ss00 += ss01[a-48] + " ";
				}
			}
			if(c== 4){
				if(i == 0){
					if(arr[i] > 0){
						output = "thousand " + ss00;
					}
				}
				else if (i==1){
					if(arr[i] > 0){
						output = "million " +ss00 + output;
					}
				}
				else if( i== 2){
					output = "billion " +ss00 + output;
				}
				else if( i == 3){
					output = ss00 + output;
				}
			}
			if(c == 3){
				if(i == 0){
					if(arr[i] > 0){
						output = "thousand " + ss00;
					}
				}
				else if (i==1){
					output = "million " +ss00 + output;
				}
				else if( i== 2){
					output = ss00 + output;
				}
			}
			if(c == 2){
				if(i == 0){
					output = "thousand " + ss00;
				}
				else if (i==1){
					output = ss00 + output;
				}
				
			}
			if(c == 1){
				if(i == 0){
					output = ss00;
				}
			}
			
		}
		return output;
	}
	
	public static String convertN1002S( int nDec){ // support nDec<1000
		String ss01[] = {"","one","two","three","four","five","six","seven","eight","nine"};
		String ss02[] = {"","","twenty","thirdty","forty","fifty","sixty","seventy","eighty","ninety"};
		String ss03[] = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String sRet="";
		int u = nDec%10;
		int d = (nDec/10)%10;
		int h= nDec/100;
		if( d!=1){
			sRet = sRet+ ss01[u];
			sRet = ss02[d]+ " "+ sRet;
		}
		else{
			//System.out.println(d);
			sRet = ss03[u];
		}
		
		if( h>0){
			sRet = ss01[h]+ " hund and " + sRet;
		}
		
		return sRet.trim();
	}

	public static String convertN2S( int nDec){ // 
		String ss01[] = {"", "T", "M", "B", "TB"};
		String sRet="";
		int count=0;
		int nTmp=0;
		while( nDec>0){
			nTmp = nDec %1000;
			sRet = convertN1002S(nTmp) + " "+ ss01[count]+" "+ sRet;
			nDec= nDec/1000;
			count++;
		}
		return sRet.trim();
		
	}

}
