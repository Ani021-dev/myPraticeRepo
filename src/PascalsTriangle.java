package src;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args){
        //To get value at given Row and Col
        System.out.println(getElementAt(5,3));

        //To print Nth Row
        System.out.println(getNthRow(6));

        //To generate the Whole Triangle
        System.out.println(generateTriangle(7));
    }

    public static int getElementAt(int row, int col){
        row = row - 1;
        col = col - 1;
        int res = 1;
        for(int i = 0; i < col; i++){
            res = res * (row - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static List<Integer> getNthRow(int row){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= row; i++){
            list.add(getElementAt(row, i));
        }
        return list;
    }

    public static List<List<Integer>> generateTriangle(int n){
        List<List<Integer>> triangle = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            triangle.add(getNthRow(i));
        }

        return triangle;
    }

}
