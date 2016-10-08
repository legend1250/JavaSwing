package Beginner;

import java.util.Random;

public class test1 {
	public static void main(String[] args){
		
		Random rd = new Random();
		int a[] = new int[10];
		
		for(int i = 0; i < a.length ; i++){
			a[i] = rd.nextInt(10);
			for(int j = 0 ; j < i ; j++){
				if (a[j] == a[i]){
					a[i] = rd.nextInt(10);
					j=-1;
					
				}
				
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int x = 0;
		boolean isMatch =false;
		for(int i = 0 ; i < a.length ; i++){
			for(int j = 0 ; j < i ; j++){
				if(a[j] == a[i]){
					isMatch = true;
					x = a[i];
				}
			}
			
		}
		System.out.println(isMatch + ": " +x);
	}
}
