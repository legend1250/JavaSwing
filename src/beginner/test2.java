/**
 * 
 */

package beginner;

import java.util.Random;

public class test2 {

	public static void main(String[] args) {
		int[][] snk= new int [100][2];
		snk[0][0]=3;
		snk[0][1]=3;
		snk[1][0]=3;
		snk[1][1]=4;
		snk[2][0]=3;
		snk[2][1]=5;
		snk[3][0]=3;
		snk[3][1]=6;
		snk[4][0]=4;
		snk[4][1]=6;
		snk[5][0]=5;
		snk[5][1]=6;
		
		Random rd = new Random();
		
		int bRow = rd.nextInt(6), bCol = rd.nextInt(7);
		System.out.println("bRow: " + bRow + "\tbCol: " +bCol);
		
		
		for (int i = 0 ; i < 6 ; i++){
			if(snk[i][0] != bRow || snk[i][1] != bCol){
				
			}
			else{
				System.out.println("2: "+snk[i][0] + " " + snk[i][1]);
			}
			if(snk[i][0] == bRow && snk[i][1] == bCol){
				System.out.println(snk[i][0] + " " + snk[i][1]);
			}
		}
	}

}
