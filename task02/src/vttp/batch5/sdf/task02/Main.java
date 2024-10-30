package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

	// Read board configuration using BufferedReader
	public static String[][] readBoard(String filePath) throws FileNotFoundException, IOException {
		String[][] tttBoard = new String[3][3];
		int Xcount = 0;
		int Ocount = 0;
		Reader reader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(reader);
		
		int row = 0;
		String line;
		while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
				tttBoard[row][i] = Character.toString(line.charAt(i));
				if (Character.toString(line.charAt(i)).equals("X")) {
					Xcount++;
				} else if (Character.toString(line.charAt(i)).equals("O")) {
					Ocount++;
				}
			}
			row++;
        }
		System.out.println("Processing: " + filePath);
		if (Xcount > Ocount) {
			System.out.println(">>> Invalid board configuration! Are you sure it's your turn? <<<");
		}
		System.out.println();
		br.close();
		return tttBoard;
	}

	public static void main(String[] args) throws Exception {

		if (args.length < 1) {
			System.err.println("Please pass a board configuration as a parameter, e.g. TTT/board0.txt");
			System.exit(-1);
		}

		String[][] tttBoard = readBoard(args[0]);
		Evaluator eval = new Evaluator(tttBoard);

		eval.printBoard(tttBoard);
		System.out.println("-----------------------");
		eval.printPositions();
	}
}
