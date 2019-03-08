import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
	private int[][] field;
	private int[] herd = new int[9];
	//private boolean[] finish = new boolean[9];
	public static void bronze(String filename) throws FileNotFoundException{
		File text = new File(filename);
		Scanner inf1 = new Scanner(text);
		Scanner inf2 = new Scanner(text);
		int col = 0;
		int row = 0;
		String line = inf1.nextLine();
		row = Integer.parseInt(inf1.next());
		col = Integer.parseInt(inf1.next());
		inf1.next();
		inf1.next();
		line = inf1.nextLine();
		line = inf1.nextLine();
		field = new int[row][col];
		for (int r = 0; r < row; r++){
			for (int c = 0; c < col; c++){
				field[r][c] = Integer.parseInt(inf1.next());
			}
			line = inf1.nextLine();
		}
		//for (int i = 0; i < 9; i++){
		//	i = false;
		//}
		while (inf1.hasNextLine()){
		bronzeHelper(Integer.parseInt(inf1.next()),
			Integer.parseInt(inf1.next()),
			Integer.parseInt(inf1.next()));
	}

	private boolean check(int index){
		boolean ans = true;
		for (int i = 0; i < 9; i++){
			if (herd[i] > herd[index]){
				ans = false;
			}
		}
		return ans;
	}
	private static boolean bronzeHelper(int row, int col, int depth){
		if (depth = 0){
			return true;
		}
		herd[0] = field[row-1][col-1];
		herd[1] = field[row-1][col];
		herd[2] = field[row-1][col+1];
		herd[3] = field[row][col-1];
		herd[4] = field[row][col];
		herd[5] = field[row][col+1];
		herd[6] = field[row+1][col-1];
		herd[7] = field[row+1][col];
		herd[8] = field[row+1][col+1];
		if (check(0)){
			field[row-1][col-1] -= 1;
		}
		if (check(1)){
			field[row-1][col] -= 1;
		}
		if (check(2)){
			field[row-1][col+1] -= 1;
		}
		if (check(3)){
			field[row][col-1] -= 1;
		}
		if (check(4)){
			field[row][col] -= 1;
		}
		if (check(5)){
			field[row][col+1] -= 1;
		}
		if (check(6)){
			field[row+1][col-1] -= 1;
		}
		if (check(7)){
			field[row+1][col] -= 1;
		}
		if (check(8)){
			field[row+1][col+1] -= 1;
		}
		return bronzeHelper(row,col,depth--);
		
	}

	

}
