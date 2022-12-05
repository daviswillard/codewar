package exercises.arrays.hourglass;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/2d-array/problem

//1 1 1 0 0 0
//0 1 0 0 0 0
//1 1 1 0 0 0
//0 0 2 4 4 0
//0 0 0 2 0 0
//0 0 1 2 4 0

public class Main {

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Main.hourglassSum(arr);

        bufferedReader.close();
        System.out.println(result);
    }

    public static int hourglassSum(List<List<Integer> > arr) {
        Integer[][] array = new Integer[6][];
        for (int i = 0; i < arr.size(); ++i) {
            array[i] = arr.get(i).toArray(new Integer[0]);
        }
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int[] temp = {
                        array[i][j], array[i][j + 1], array[i][j + 2],
                        array[i + 1][j + 1],
                        array[i + 2][j], array[i + 2][j + 1], array[i + 2][j + 2]
                };
                result = Math.max(result, computeHourglass(temp));
            }
        }
        return result;
    }

    private static int computeHourglass(int[] sumArr) {
        return Arrays.stream(sumArr).sum();
    }
}
