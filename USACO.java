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
		int d;
		//String line; //inf1.nextLine();
		row = Integer.parseInt(inf1.next());
		col = Integer.parseInt(inf1.next());
		//System.out.println("" + row + " " + col);
		d = Integer.parseInt(inf1.next());
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
		for (int r = 0; r < field.length; r++){
			for (int c = 0; c < field[r].length;c++){
				System.out.print(field[r][c] + " ");
			}
			System.out.println("");
		}
		System.out.println("       ");
		//for (int i = 0; i < 9; i++){
		//	i = false;
		//}
		while (inf1.hasNext()){
		bronzeHelper(Integer.parseInt(inf1.next())-1,
			Integer.parseInt(inf1.next())-1,
			Integer.parseInt(inf1.next()),
			herd,field);
			//inf1.nextLine();
		}
		int temp = 0;
		for (int r = 0; r < field.length; r++){
			for (int c = 0; c < field[r].length;c++){
				temp = field[r][c];
				if (d - temp > 0){
					field[r][c] = d - temp;
				}
				else{
					field[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < field.length; r++){
			for (int c = 0; c < field[r].length;c++){
				System.out.print(field[r][c] + " ");
			}
			System.out.println("");
		}

		int ans = 0;
		for (int r = 0; r < field.length; r++){
			for (int c = 0; c < field[r].length;c++){
				ans += field[r][c];
			}
		}
	//	System.out.println(ans);
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
	//	System.out.println("" + row + " " + col);

		//if (depth == 0){
	//		return true;
	//	}


		while(depth != 0){
			herd[0] = field[row][col];
			herd[1] = field[row][col+1];
			herd[2] = field[row][col+2];
			herd[3] = field[row+1][col];
			herd[4] = field[row+1][col+1];
			herd[5] = field[row+1][col+2];
			herd[6] = field[row+2][col];
			herd[7] = field[row+2][col+1];
			herd[8] = field[row+2][col+2];
		//int didIt = false;
		int max = findMax(herd);

		//	System.out.println("" + max);
		for (int r = 0; r < 3; r++){
			for (int c = 0; c < 3; c++){
				if (field[row + r][col + c] == max){
				//	System.out.println("" + max);
					field[row + r][col + c] -= 1;
				//	didIt = true;
				}
			}
		}
		//if (didIt){
		//	max -= 1;
		//}
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
