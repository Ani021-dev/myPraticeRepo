package src;

import java.util.*;

public class MissingAndDup {
    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 2, 4, 5);

        System.out.println(getMissingAndDuplicated(a));
    }

    private static ArrayList<Integer> getMissingAndDuplicated(List<Integer> a) {
        int n = a.size();
        int xr = 0;

        //xor the each element correspoding to their indices
        for (int i = 0; i < n; i++) {
            xr ^= a.get(i); //xor the element
            xr ^= (i + 1); //xoring the indices
        }

        int number = xr ^ -(xr - 1); //isolate the rightmost bit
        int one = 0;
        int zero = 0;

        //seperating the elements into two group based on their rightmost bit
        for (int i = 0; i < n; i++) {
            if ((a.get(i) & number) != 0)
                one ^= a.get(i);
            else
                zero ^= a.get(i);
        }

        //xor the indices of the two seperated groups
        for (int i = 1; i <= n; i++) {
            if((i & number) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        //finding the duplicate number
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(a.get(i) == zero) cnt++;
        }

        if(cnt == 2) return new ArrayList<>(Arrays.asList(zero, one)); //returning when zero element is duplicate
        return new ArrayList<>(Arrays.asList(one, zero)); //returning when one element is dup
    }
}
