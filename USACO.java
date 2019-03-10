import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
	public static int bronze(String filename) throws FileNotFoundException{
		int[][]field;
		int[] herd = new int[9];
		File text = new File(filename);
		Scanner inf1 = new Scanner(text);
		//Scanner inf2 = new Scanner(text);
		int col = 0;
		int row = 0;
		int d;

		row = Integer.parseInt(inf1.next());
		col = Integer.parseInt(inf1.next());

		d = Integer.parseInt(inf1.next());
		Integer.parseInt(inf1.next());

		field = new int[row][col];
		for (int r = 0; r < row; r++){
			for (int c = 0; c < col; c++){
				field[r][c] = Integer.parseInt(inf1.next());
			}
		}

		while (inf1.hasNext()){
		bronzeHelper(Integer.parseInt(inf1.next())-1,
			Integer.parseInt(inf1.next())-1,
			Integer.parseInt(inf1.next()),
			herd,field);

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



		int ans = 0;
		for (int r = 0; r < field.length; r++){
			for (int c = 0; c < field[r].length;c++){
				ans += field[r][c];
			}
		}

	return ans * 72 * 72;

	}


	private static int findMax(int[] herd){
		int max = 0;
		for (int i = 0; i < 9; i++){
			if (max < herd[i]){
				max = herd[i];
			}
		}
		return max;
	}
	private static boolean bronzeHelper(int row, int col, int depth,int[] herd, int[][] field){
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
		int max = findMax(herd);

		for (int r = 0; r < 3; r++){
			for (int c = 0; c < 3; c++){
				if (field[row + r][col + c] == max){
					field[row + r][col + c] -= 1;
				}
			}
		}
		depth--;
	}
	return true;
	}

	private static int getSum(int row, int col,int[][] Pfield){
		int ans = 0;
		//System.out.println(row + " " + col);
		if (row > 0 && Pfield[row-1][col] >= 0){
			ans += Pfield[row-1][col];
		}
		if (row < Pfield.length - 1 && Pfield[row+1][col] >= 0){
			ans += Pfield[row+1][col];
		}
		if (col > 0 && Pfield[row][col - 1] >= 0){
			ans += Pfield[row][col - 1];
		//	System.out.println(ans + "+++++++++++++++++");
		}
		if (col < Pfield[row].length - 1 && Pfield[row][col+1] >= 0){
			ans += Pfield[row][col+1];
		}
		//System.out.println(ans + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return ans;
	}
	private static void expand(int[][] Cfield,int[][] Pfield){
		for (int r = 0; r < Cfield.length; r++){
			for (int c = 0; c < Cfield[r].length; c++){
				if (Cfield[r][c] >= 0){
					//System.out.println("" + getSum(r,c,Pfield) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				Cfield[r][c] = getSum(r,c,Pfield);
				}
			}
		}
	}

	public static void copy(int[][] cur, int[][] prev){
		for (int r = 0; r < prev.length; r++){
			for (int c = 0; c < prev[r].length; c++){
				prev[r][c] = cur[r][c];
			}
		}
	}
 	public static int silver(String filename) throws FileNotFoundException{
		File text = new File(filename);
		Scanner inf1 = new Scanner(text);
		int[][] fieldCur;
		int[][] fieldPrev;
		int row = Integer.parseInt(inf1.next());
		int col = Integer.parseInt(inf1.next());
		int time = Integer.parseInt(inf1.next());
		int startRow;
		int startCol;
		int endRow;
		int endCol;
		int count = row;
		int countIndex = 0;
		String boardString = "";
		while(count >= 0){
			boardString += inf1.nextLine();
			count--;
		}
		//System.out.println(boardString);
		fieldCur = new int[row][col];
		fieldPrev = new int[row][col];
		for (int r = 0; r < row; r++){
			for (int c = 0; c < col; c++){
				//System.out.println(inf1.next());
				if (boardString.substring(countIndex,countIndex+1).equals("*")){
					fieldCur[r][c] = -1;
				}
				else{
					fieldCur[r][c] = 0;
				}
				countIndex++;
			}
		}

		startRow = Integer.parseInt(inf1.next()) - 1;
		startCol = Integer.parseInt(inf1.next()) - 1;
		endRow = Integer.parseInt(inf1.next()) - 1;
		endCol = Integer.parseInt(inf1.next()) - 1;
		fieldCur[startRow][startCol] = 1;
	//	System.out.println(startRow + " " + startCol);
	//	debug(fieldCur);
		/**
		if (startRow > 0 && fieldCur[startRow-1][startCol] >= 0){
			fieldCur[startRow][startCol] += 1;
		}
		if (startRow < fieldCur.length - 1 && fieldCur[startRow+1][startCol] >= 0){
			fieldCur[startRow][startCol] += 1;
		}
		if (startCol > 0 && fieldCur[startRow][startCol-1] >= 0){
			fieldCur[startRow][startCol] += 1;
		}
		if (startCol < fieldCur[0].length - 1 && fieldCur[startRow][startCol+1] >= 0){
			fieldCur[startRow][startCol] += 1;
		}
		**/

		//fieldPrev = fieldCur;
		copy(fieldCur,fieldPrev);
		//debug(fieldCur);
		while(time > 0){

			for (int r = 0; r < row; r++){
				for (int c = 0; c < col; c++){
				//	System.out.print(fieldPrev[r][c]);
				}
			//	System.out.println("");
			}
			//System.out.println("---------------------");
			expand(fieldCur,fieldPrev);
			time--;
			copy(fieldCur,fieldPrev);
			//debug(fieldCur);
		}
//debug(fieldCur);
		//System.out.println(endRow + " " + endCol);
		return fieldCur[endRow][endCol];
 	}

	private static void debug(int[][] thing){
		for (int r = 0; r < thing.length; r++){
			for (int c = 0; c < thing[r].length; c++){
				if (thing[r][c] < 0 || thing[r][c] > 9 && thing[r][c] < 100){
				System.out.print(" " + " " + thing[r][c]);
			}
			if (thing[r][c] > -1 && thing[r][c] < 10){
				System.out.print("   "  + thing[r][c]);
			}
			if (thing[r][c] > 99){
				System.out.print(" " + thing[r][c]);
			}
			}
			System.out.println("");
		}
		System.out.println("----------------------------------");
	}
}
