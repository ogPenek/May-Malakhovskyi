public public class NSloni {

    static int N = 8;
    static int[][] board = new int[N][N];

    public static void main(String[] args) {
        placeBishops(0, 0);
    }

    static void placeBishops(int row, int count) {
        if (count == N) {
            printBoard();
            System.out.println("==============");
            return;
        }

        if (row >= N) return;

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                placeBishops(row + 1, count + 1);
                board[row][col] = 0;
            }
        }

        // Пропустити цей рядок (без розміщення слона)
        placeBishops(row + 1, count);
    }

    static boolean isSafe(int row, int col) {
        // Перевірка діагоналей
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    if (Math.abs(i - row) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
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

