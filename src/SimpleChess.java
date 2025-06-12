
import java.util.Scanner;

public class SimpleChess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = " . ";
            }
        }

        board[0][0] = " R ";

        while (true) {
            printBoard(board);

            System.out.println("Enter piece row (0-7) to move: ");
            int fromRow = scanner.nextInt();

            System.out.println("Enter piece column (0-7) to move: ");
            int fromCol = scanner.nextInt();

            System.out.print("Enter destination row (0–7): ");
            int toRow = scanner.nextInt();

            System.out.print("Enter destination column (0–7): ");
            int toCol = scanner.nextInt();

            if (isValid(fromRow, fromCol, toRow, toCol, board)) {
                board[toRow][toCol] = board[fromRow][fromCol];
                board[fromRow][fromCol] = " . ";
                System.out.println("Move completed.\n");
            } else {
                System.out.println("Invalid move.\n");
            }
        }
    }

    public static void printBoard(String[][] board) {
        System.out.println("   0 1 2 3 4 5 6 7");
        for (int row = 0; row < 8; row++) {
            System.out.print(row + "  ");
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean isValid(int fromRow, int fromCol, int toRow, int toCol, String[][] board) {
        if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 ||
                toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            return false;
        }
        return !board[fromRow][fromCol].equals(" . ") && board[toRow][toCol].equals(" . ");
    }
}
