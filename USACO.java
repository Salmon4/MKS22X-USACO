import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
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
	//row = line.charAt(0);
	//col = line.charAt(1);
	//int end = line.charAt(line.length()-1);
	int[][] field = new int[row][col];
	for (int r = 0; r < row; r++){
		//line = inf1.nextLine();
		for (int c = 0; c < col; c++){
			//field[r][c] = line.next();
			field[r][c] = Integer.parseInt(inf1.next());
		}
	}
	}

	

}
