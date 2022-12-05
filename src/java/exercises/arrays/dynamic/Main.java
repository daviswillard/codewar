package exercises.arrays.dynamic;

//https://www.hackerrank.com/challenges/dynamic-array/problem
/*
2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Main.dynamicArray(n, queries);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();

    }

    public static List<Integer> dynamicArray(int n, List<List <Integer> > queries) {
        int lastAnswer = 0;

        List<Integer> ans = new ArrayList<>();
        List<List <Integer> > arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(new ArrayList<>());
        }

        for (List<Integer> iter : queries) {
            int idx = ((iter.get(1) ^ lastAnswer) % n);
            if (iter.get(0) == 1) {
                arr.get(idx).add(iter.get(2));
            } else {
                lastAnswer = arr.get(idx).get(iter.get(2) % arr.get(idx).size());
                ans.add(lastAnswer);
            }
        }
        return ans;
    }
}
