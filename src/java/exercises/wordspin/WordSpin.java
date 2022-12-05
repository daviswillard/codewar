package exercises.wordspin;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WordSpin {
    public static void main(String[] args) {
        WordSpin word = new WordSpin();
        System.out.println(word.spinWords("Welcum"));
        System.out.println(word.spinWords("If I need a body, I'll fuck it"));
        System.out.println(word.spinWordsAlter("Welcum"));
        System.out.println(word.spinWordsAlter("If I need a body, I'll fuck it"));
    }

    public String spinWordsAlter(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }

    public String spinWords(String sentence) {
        StringBuilder           str = new StringBuilder();
        ArrayList<String>       list = new ArrayList<>(List.of(sentence.split(" ")));

        for (int i = 0; i < list.size(); ++i) {
            String iter = list.get(i);
            if (iter.length() > 4) {
                StringBuilder kek = new StringBuilder(iter);
                list.set(i, kek.reverse().toString());
            }
            str.append(list.get(i));
            if (i + 1 != list.size()) {
                str.append(' ');
            }
        }
        return str.toString();
    }
}
