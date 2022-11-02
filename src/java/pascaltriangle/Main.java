package pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main kok = new Main();
        System.out.println(kok.generate(5));
    }

    public List<List<Integer> > generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            ArrayList<Integer> local = new ArrayList<>(i);
            local.add(1);
            for (int j = 1; j < i; ++j) {
                ArrayList<Integer> temp = (ArrayList<Integer>) list.get(i - 1);
                local.add(temp.get(j - 1) + temp.get(j));
            }
            if (i > 0) {
                local.add(1);
            }
            list.add(local);
        }
        return list;
    }
}
