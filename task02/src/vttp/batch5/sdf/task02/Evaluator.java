package vttp.batch5.sdf.task02;

public class Evaluator {
    private final String[][] tttBoard;

    public Evaluator(String[][] tttBoard) {
        this.tttBoard = tttBoard;
    }

    public void printBoard(String[][] tttBoard) {
		System.out.println("Board:");
		for (int x = 0; x < tttBoard.length; x++) {
			for (int y = 0; y < tttBoard[x].length; y++) {
				System.out.printf("%s", tttBoard[x][y]);
			}
			System.out.println();
		}
	}

    public int checkUtility(int x, int y, String player) {
        // Create a temporary board
        String[][] tempBoard = new String[3][3];
        for (int i = 0; i < tttBoard.length; i++) {
            tempBoard[i] = tttBoard[i].clone();
        }

        // Plays the next move on the temporary board
        tempBoard[y][x] = player;
        
        // Check row for win
        if (x == 0 && tempBoard[y][1].equals(player) && tempBoard[y][2].equals(player)) return 1;
        if (x == 1 && tempBoard[y][0].equals(player) && tempBoard[y][2].equals(player)) return 1;
        if (x == 2 && tempBoard[y][0].equals(player) && tempBoard[y][1].equals(player)) return 1;

        // Check column for win
        if (y == 0 && tempBoard[1][x].equals(player) && tempBoard[2][x].equals(player)) return 1;
        if (y == 1 && tempBoard[0][x].equals(player) && tempBoard[2][x].equals(player)) return 1;
        if (y == 2 && tempBoard[0][x].equals(player) && tempBoard[1][x].equals(player)) return 1;


        // Check diagonals for win
        if (x == 0 && y == 0 && tempBoard[1][1].equals(player) && tempBoard[2][2].equals(player)) return 1;
        if (x == 1 && y == 1 && tempBoard[0][0].equals(player) && tempBoard[2][2].equals(player)) return 1;
        if (x == 2 && y == 2 && tempBoard[1][1].equals(player) && tempBoard[0][0].equals(player)) return 1;

        if (x == 0 && y == 2 && tempBoard[1][1].equals(player) && tempBoard[0][2].equals(player)) return 1;
        if (x == 1 && y == 1 && tempBoard[2][0].equals(player) && tempBoard[0][2].equals(player)) return 1;
        if (x == 0 && y == 2 && tempBoard[1][1].equals(player) && tempBoard[2][0].equals(player)) return 1;

        // Check opponent win condition
        if (player.equals("X")) {
            for (int row = 0; row < tempBoard.length; row++) {
                for (int col = 0; col < tempBoard[row].length; col++) {
                    if (tempBoard[row][col].equals(".")) {
                        if (checkUtility(col, row, "O") == 1) { return -1; }
                    }
                }
            }
        }
        return 0;
    }

    // Print all legal positions and corresponding utility for the specified position
    public void printPositions() {
        for (int row = 0; row < tttBoard.length; row++) {
			for (int col = 0; col < tttBoard[row].length; col++) {
                if (tttBoard[row][col].equals(".")) {
                    System.out.printf("y=%d, x=%d, utility=%d\n", row, col, checkUtility(col, row, "X"));
                }
			}
		}
    }
}
