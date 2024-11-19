import java.util.Scanner;
public class Main {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] TicToeBoard= new String[ROWS][COLS];
    private static String firstPlayer = "X";
    private static int moves = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        do {
            clearBoard();
            displayBoard();

            while (true) {
                int rowMove = SafeInput.getRangedInt(console, "Enter the row # 1 to 3: ", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(console, "Enter the column # 1 to 3: ", 1, 3) - 1;

                if (valMove(rowMove, colMove)) {
                    TicToeBoard[rowMove][colMove] = firstPlayer;
                    moves++;
                    displayBoard();

                    if (isWin(firstPlayer)) {
                        System.out.println(firstPlayer + " wins tic tac toe!");
                        break;
                    } else if (isTie()) {
                        System.out.println("This game is a draw");
                        break;
                    }
                    firstPlayer = (firstPlayer.equals("X")) ? "O" : "X";
                } else {
                    System.out.println("Wrong move, try again.");
                }
            }

        } while (SafeInput.getYNConfirm(console, "Wanat to play again?"));
    }

    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                TicToeBoard[row][col] = " ";
            }
        }
    }
    private static void displayBoard() {
        System.out.println();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(TicToeBoard[row][col]);
                if (col < COLS - 1) System.out.print(" | ");
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }
    private static boolean valMove(int row, int col) {
        return TicToeBoard[row][col].equals(" ");
    }
    private static boolean isWin(String player) {
        return RowWin(player) || columnnWin(player) || DiagWIN(player);
    }
    private static boolean RowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (TicToeBoard[row][0].equals(player) && TicToeBoard[row][1].equals(player) && TicToeBoard[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean columnnWin(String player) {
        for (int col = 0; col < COLS; col++) { if (TicToeBoard[0][col].equals(player) && TicToeBoard[1][col].equals(player) && TicToeBoard[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean DiagWIN(String player) { if (TicToeBoard[0][0].equals(player) && TicToeBoard[1][1].equals(player) && TicToeBoard[2][2].equals(player)) {
            return true;
        }
        if (TicToeBoard[0][2].equals(player) && TicToeBoard[1][1].equals(player) && TicToeBoard[2][0].equals(player)) {
            return true;
        }
        return false;
    }
    private static boolean isTie() {
        if (moves == 9) {
            return true;
        }
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (TicToeBoard[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return false;
    }
}

