package src;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args){
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        System.out.println(Arrays.deepToString(setMatrix(matrix)));
    }

    public static int[][] setMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }

        for(int i  = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(firstRow){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }

        if(firstCol){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
