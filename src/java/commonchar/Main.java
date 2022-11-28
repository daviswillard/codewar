package commonchar;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.commonChars(new String[]{"cool","lock","cook"}));
    }
}


class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        char[] table = new char[26];
        char[] res = new char[26];

        for (int i = 0; i < words[0].length(); ++i) {
            table[words[0].charAt(i) - 97]++;
        }
        for (int i = 1; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                res[words[i].charAt(j) - 97]++;
            }
            for (int j = 0; j < table.length; ++j) {
                if (res[j] == table[j]) {
                    if (res[j] == 0) {
                        continue ;
                    }
                }
                else if (res[j] < table[j]) {
                    table[j] = res[j];
                }
                res[j] = 0;
            }
        }
        for (int j = 0; j < table.length; ++j) {
            while (table[j]-- > 0) {
                result.add(Character.valueOf((char)(j + 97)).toString());
            }
        }
        return result;
    }
}