package medium;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] boxes = new int[n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int value = board[r][c] - '0';
                int boxIndex = (r / 3) * 3 + c / 3;
                if ((rows[r] >> value) % 2 == 1 || (cols[c] >> value) % 2 == 1 || (boxes[boxIndex] >> value) % 2 == 1) {
                    return false;
                }
                rows[r] |= 1 << value;
                cols[c] |= 1 << value;
                boxes[boxIndex] |= 1 << value;
            }
        }
        return true;
    }
}
