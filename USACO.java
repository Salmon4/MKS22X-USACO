public class USACO{
	public static int bronze(String filename){
	File text = new File(filename);
	Scanner inf1 = Scanner(text);
	Scanner inf2 = Scanner(text);
	int col = 0;
	int row = 0;
	String line = inf1.nextLine();
	row = line.charAt(0);
	col = line.charAt(1);
	//int end = line.charAt(line.length()-1);
	int[][] field = new int[row][col]
	for (int r = 0; r < row; r++){
		String line = inf1.nextLine();
		for (int c = 0; c < col; c++){
			field[r][c] = line.charAt(a);
		}
	}

}
