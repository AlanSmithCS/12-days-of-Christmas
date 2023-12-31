import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW_Better {
    public static List<Integer> encode(String text) {
        int dictSize = 256;
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            dictionary.put(String.valueOf((char) i), i);
        }

        String foundChars = "";
        List<Integer> result = new ArrayList<>();
        for (char character : text.toCharArray()) {
            String charsToAdd = foundChars + character;
            if (dictionary.containsKey(charsToAdd)) {
                foundChars = charsToAdd;
            } else {
                result.add(dictionary.get(foundChars));
                dictionary.put(charsToAdd, dictSize++);
                foundChars = String.valueOf(character);
            }
        }
        if (!foundChars.isEmpty()) {
            result.add(dictionary.get(foundChars));
        }
        return result;
    }

    public static String decode(List<Integer> encodedText) {
        int dictSize = 256;
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }

        String characters = String.valueOf((char) encodedText.remove(0).intValue());
        StringBuilder result = new StringBuilder(characters);
        for (int code : encodedText) {
            String entry = dictionary.containsKey(code)
                    ? dictionary.get(code)
                    : characters + characters.charAt(0);
            result.append(entry);
            dictionary.put(dictSize++, characters + entry.charAt(0));
            characters = entry;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println("LZW");
        String lyrics = "On the . day of Christmas, my true love sent to me," +
                "Twelve drummers drumming," +
                "Eleven pipers piping," +
                "Ten lords a-leaping," +
                "Nine ladies dancing," +
                "Eight maids a-milking," +
                "Seven swans a-swimming," +
                "Six geese a-laying," +
                "Five golden rings," +
                "Four calling birds," +
                "Three french hens," +
                "Two turtle doves and," +
                "A partridge in a pear tree";
        System.out.println(encode(lyrics));
    }
}
