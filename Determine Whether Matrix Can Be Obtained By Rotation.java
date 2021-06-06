class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        if (checkEqual(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            final int[][] rotated = rotate(mat);
            if (checkEqual(rotated, target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkEqual(int[][] mat, int[][] target) {
        int row1, col1, row2, col2;
        boolean flag = true;

        row1 = mat.length;
        col1 = mat[0].length;
        row2 = target.length;
        col2 = target[0].length;

        if(row1 != row2 || col1 != col2){
            return false;
        } else {
            for(int i = 0; i < row1; i++){
                for(int j = 0; j < col1; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        return matrix;
    }
}
