/**
 * @author Marcelo Shen, Ashley Mead, Brandon Yi
 */
public class WordSearch {

    /**
     * Test Case
     * 
     * @param args command-line arguments that are useless here
     */
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word)); // should print true
    }

    /**
     * Given a 2D board and a word, finds if the word exists in the grid
     * 
     * Levels: length of the word
     * Branches: 4 for each branch if it is valid: see recursion tree below
     * Complexity: O(4^n) time and space;
     * 
     * @param board a 2D array containing letters
     * @param word a string to search board for
     * @return whether the board contains the word
     */
    public static boolean exist(char[][] board, String word) {
        // check for null input
        if (board == null || word == null) {
            return false;
        }
        // Loop through all letters on the board as starting positions
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recExist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Board:
     * [['A', 'B', 'C', 'E'], 
     * ['S', 'F', 'C', 'S'], 
     * ['A', 'D', 'E', 'E']]
     * 
     * Word:
     * "ABCCED"
     * 
     * 
     * 
     *                                                                              (0, 0)
     *                                                      __                   ______A________                 __
     *                                                    /                    /                \                  \ 
     *                                                 (1, 0)               (-1, 0)           (0, 1)              (0, -1)
     *                          __                  _____AB_____        __    (X)              AS (X)               (X)
     *                        /                   /             \         \                                              
     *                     (2, 0)              (0, 0)        (1, 1)     (1, -1)
     *            __     ___ABC___      __     AB* (X)       ABF (X)      (X)
     *          /      /          \       \
     *       (3, 0)  (1, 0)     (2, 1) (2, -1)
     *      ABCE (X)  ABC* (X)   ABCC   (X)       
     *                           ... (continue for the "ABCC" branch)
     *
     * @param board the 2D array containing letters
     * @param word the string to search board for
     * @param index the current depth of the branch / the current index of the string
     * @param row row of the current checked letter
     * @param col column of the current checked letter
     * @return whether the board contains the word in this branch
     */
    private static boolean recExist(char[][] board, String word, int index, int row, int col) {

        // Check out of bound
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        // Check whether the letter at the index of the string matches the letter at the current position in the board
        if (word.charAt(index) != board[row][col]) {
            return false;
        // If it does not match, replace the letter with a * so it does not get used again
        } else {
            board[row][col] = '*';
        }

        // Check whether the word is completed
        if (index >= word.length() - 1) {
            return true;
        }

        // Repeat the process for each letter in all sequentially adjacent cells 
        // that are horizontally and vertically neighboring
        boolean result = recExist(board, word, index + 1, row + 1, col)
                || recExist(board, word, index + 1, row - 1, col) || recExist(board, word, index + 1, row, col + 1)
                || recExist(board, word, index + 1, row, col - 1);

        board[row][col] = word.charAt(index);

        return result;
    }

}
