package beginner;

public class test4 {
	public static void main(String[] args){
		
		int n = 100216;
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
		
		/*System.out.println(c);
		for(int i = 0 ; i < c ; i++){
			System.out.println(arr[i]);
		}
		
		int x = 317;
		String qq1[] = {"","one","two","three","four","five","six","seven","eight","nine"};
		String qq2[] = {"0","one","twenty","thirdty","forty","fifty","sixty","seventy","eighty","ninety"};
		String qq3[] = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		
		String ss = "";
		for(int i = 0 ; i < Integer.toString(x).length() ; i++){
			if(x >= 100){
				if(x%100 >= 20){
					String qw = Integer.toString(x);
					char a = qw.charAt(i);
					if(i == 0){
						ss += qq1[a-48] + " hundred ";
					}
					else if ( i == 1){
						ss += qq2[a-48] + " ";
					}
					else if(i == 2){
						ss += qq1[a-48] + " ";
					}
				}else{
					if(i == 0){
						String qw = Integer.toString(x);
						char a = qw.charAt(i);
						ss += qq1[a-48] + " hundred and ";
					}
					else {
						ss +=qq3[(x%100)-10] + " ";
						break;
					}
				}
				
			}
			
		}
		//System.out.println(ss);
		*/
		
		String output = "";
		for(int i = 0 ; i < c ; i++){
			String ss00 = "";
		
			for(int j = 0 ; j < Integer.toString(arr[i]).length() ; j++){
				String ss01[] = {"","one","two","three","four","five","six","seven","eight","nine"};
				String ss02[] = {"0","one","twenty","thirdty","forty","fifty","sixty","seventy","eighty","ninety"};
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
				
			
			//output +=ss;
		}
		
		System.out.println(output);
		
	}
	
	
}
