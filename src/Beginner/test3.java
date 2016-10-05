package Beginner;

public class test3 {
	public static void main(String[] args) {
		int nRow = 10, nCol = 10;
		int[][] arr = new int[nRow][nCol];
		int[][] snk= new int [100][2];
		int len_snk=0;
		len_snk=3;
		snk[0][0]=3;
		snk[0][1]=3;
		snk[1][0]=3;
		snk[1][1]=4;
		snk[2][0]=3;
		snk[2][1]=5;
		/*int[][] snk= {
				{3, 1},
				{3, 2},
				{3, 3},			
				};*/
		for(int i = 0 ; i < len_snk;i++){
			for (int j = 0 ; j < 2 ; j++){
				System.out.print(snk[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("After: ");
		//
		len_snk+=1;
		
		for(int i = 0 ; i < len_snk;i++){
			for(int j = 0 ; j < 2 ; j++){
				snk[i+1][j]=snk[i][j];
			}
		}
		
		for(int i = 0 ; i < len_snk;i++){
			for (int j = 0 ; j < 2 ; j++){
				System.out.print(snk[i][j]+" ");
			}
			System.out.println();
		}
	}
}
