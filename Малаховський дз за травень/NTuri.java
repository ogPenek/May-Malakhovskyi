public class NTuri {

    static int N = 8; // Розмір дошки (можна змінити)
    static int[][] board = new int[N][N];

    public static void main(String[] args) {
        placeRooks(0);
    }

    // Рекурсивне розміщення тур
    static void placeRooks(int row) {
        if (row == N) {
            printBoard();
            System.out.println("==============");
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                placeRooks(row + 1);
                board[row][col] = 0;
            }
        }
    }

    static boolean isSafe(int row, int col) {
        // Перевірка вертикалі
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
