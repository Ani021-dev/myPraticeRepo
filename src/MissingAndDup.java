package src;

import java.util.*;

public class MissingAndDup {
    public static void main(String[] args) {
        List<Integer> a = List.of(1, 1, 3, 4, 5);

        System.out.println(getMissingAndDuplicated(a));
    }

    private static ArrayList<Integer> getMissingAndDuplicated(List<Integer> a) {
        int n = a.size();
        int xr = 0;

        for(int i = 0; i < n; i++){
            xr = xr ^ a.get(i);
            xr = xr ^ (i+1);
        }

        int number = xr ^ -(xr-1);
        int one = 0;
        int zero = 0;

        for(int i = 0; i < n; i++){
            if((a.get(i) & number) != 0)
                one ^= a.get(i);
            else
                zero ^= a.get(i);
        }

        for(int i = 1; i <= n; i++){
            if((i & number) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(a.get(i) == zero) cnt++;
        }

        if(cnt == 2) return new ArrayList<>(List.of(zero, one));
        return new ArrayList<>(List.of(one, zero));
    }
}
