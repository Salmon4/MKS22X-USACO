import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
//	private int[][] field;
	//private int[] herd = new int[9];
	//private boolean[] finish = new boolean[9];
	public static int bronze(String filename) throws FileNotFoundException{
		int[][]field;
		int[] herd = new int[9];
		File text = new File(filename);
		Scanner inf1 = new Scanner(text);
		Scanner inf2 = new Scanner(text);
		int col = 0;
		int row = 0;
		//String line; //inf1.nextLine();
		row = Integer.parseInt(inf1.next());
		col = Integer.parseInt(inf1.next());
		//System.out.println("" + row + " " + col);
		Integer.parseInt(inf1.next());
		Integer.parseInt(inf1.next());
		//line = inf1.nextLine();
		//line = inf1.nextLine();
		field = new int[row][col];
		for (int r = 0; r < row; r++){
			for (int c = 0; c < col; c++){
				field[r][c] = Integer.parseInt(inf1.next());
			}
			//line = inf1.nextLine();
		}
		//for (int i = 0; i < 9; i++){
		//	i = false;
		//}
		while (inf1.hasNext()){
		bronzeHelper(Integer.parseInt(inf1.next()),
			Integer.parseInt(inf1.next()),
			Integer.parseInt(inf1.next()),
			herd,field);
			//inf1.nextLine();
		}

		int ans = 0;
		for (int r = 0; r < field.length; r++){
			for (int c = 0; c < field[r].length;c++){
				ans += field[r][c];
			}
		}
		System.out.println(ans);
	return ans * 72 * 72;

	}


	private static int findMax(int[] herd){
		int max = 0;
		for (int i = 0; i < 8; i++){
			if (max < herd[i]){
				max = herd[i];
			}
		}
		return max;
	}
	private static boolean bronzeHelper(int row, int col, int depth,int[] herd, int[][] field){

		//if (depth == 0){
	//		return true;
	//	}


		herd[0] = field[row][col];
		herd[1] = field[row][col];
		herd[2] = field[row][col];
		herd[3] = field[row][col];
		herd[4] = field[row][col];
		herd[5] = field[row][col];
		herd[6] = field[row][col];
		herd[7] = field[row][col];
		herd[8] = field[row][col];
		while(depth != 0){
		int max = findMax(herd);
			//System.out.println("" + max);
		for (int r = 0; r < 2; r++){
			for (int c = 0; c < 2; c++){
				if (field[row + r][col + c] == max){
					System.out.println("" + max);
					field[row + r][col + c] -= 1;
				}
			}
		}
		depth--;
	}
	//	return bronzeHelper(row,col,depth--,herd,field);
	return true;
	}
		/**
		if (check(0, herd) && field[row-1][col-1] != 0){
			field[row-1][col-1] -= 1;
		}
		if (check(1, herd) && field[row-1][col] != 0){
			field[row-1][col] -= 1;
		}
		if (check(2, herd) && field[row-1][col+1] != 0){
			field[row-1][col+1] -= 1;
		}
		if (check(3, herd) && field[row][col-1] != 0){
			field[row][col-1] -= 1;
		}
		if (check(4, herd) && field[row][col] != 0){
			field[row][col] -= 1;
		}
		if (check(5, herd) && field[row][col+1] != 0){
			field[row][col+1] -= 1;
		}
		if (check(6, herd) && field[row+1][col-1] != 0){
			field[row+1][col-1] -= 1;
		}
		if (check(7, herd) && field[row+1][col] != 0){
			field[row+1][col] -= 1;
		}
		if (check(8, herd) && field[row+1][col+1] != 0){
			field[row+1][col+1] -= 1;
		}
		return bronzeHelper(row,col,depth--,herd,field);

	}
	**/


}
