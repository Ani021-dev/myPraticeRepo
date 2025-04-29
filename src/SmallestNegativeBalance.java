package src;

import java.io.*;
        import java.util.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'smallestNegativeBalance' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY debts as parameter.
     */

    public static Map<String, Integer> smallestNegativeBalance(List<List<String>> debts) {
        // Write your code here
        HashMap<String, Integer> sMap = new HashMap<>();
        Map<String, Integer> ret = new HashMap<>();

        for(int i = 0; i < debts.size(); i++){
            if(sMap.isEmpty()){
                sMap.put(debts.get(i).get(0), -(Integer.parseInt(debts.get(i).get(2))));
                sMap.put(debts.get(i).get(0), Integer.parseInt(debts.get(i).get(2)));
            }else {
                if(sMap.containsKey(debts.get(i).get(0))){
                    sMap.put(debts.get(i).get(0), sMap.get(debts.get(i).get(0)) - Integer.parseInt(debts.get(i).get(2)));
                }else {
                    sMap.put(debts.get(i).get(0), -(Integer.parseInt(debts.get(i).get(2))));
                }

                if(sMap.containsKey(debts.get(i).get(1))){
                    sMap.put(debts.get(i).get(1), sMap.get(debts.get(i).get(1)) - Integer.parseInt(debts.get(i).get(2)));
                }else {
                    sMap.put(debts.get(i).get(1), -(Integer.parseInt(debts.get(i).get(2))));
                }
            }
        }

        int min = sMap.values().stream().mapToInt(entry -> entry).min().orElse(Integer.MAX_VALUE);

        ret = sMap.entrySet().stream()
            .filter(i -> i.getValue() == min)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return ret;
    }

}

public class SmallestNegativeBalance {
    public static void main(String[] args) throws IOException {
        List<List<String>> debts = new ArrayList<>();

        debts.add(Arrays.asList("Alex", "Blake", "7"));
        debts.add(Arrays.asList("Blake", "Alex", "3"));
        debts.add(Arrays.asList("Casey", "Alex", "4"));
        debts.add(Arrays.asList("Casey", "Alex", "1"));
        debts.add(Arrays.asList("Casey", "Alex", "7"));

        Map<String, Integer> result = Result.smallestNegativeBalance(debts);

        result.entrySet().forEach(System.out::println);
    }
}

