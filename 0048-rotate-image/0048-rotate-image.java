class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = temp;
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = temp;
                temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = temp;
            }
        }
    }
}