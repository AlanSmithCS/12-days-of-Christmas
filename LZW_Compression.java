import java.util.HashMap;
import java.util.Map;

/*
1. Compress once (e.g AABAABBABAAB -> 11BAB1)
2. Convert to binary
3. Compress binary (01100001 -> 210002)

4. Decode in seperate file
*/

public class LZW_Compression {
    // Assumes there are no null values between entries in the map
    public static boolean inStringMap(String str, Map<Byte, String> map) {
        boolean present = false;

        byte pos = -128;
        String value = map.get(pos);
        while (value != null) {
            if (value.equals(str)) {
                present = true;
                break;
            }
            pos++;
            value = map.get(pos);
        }

        return present;
    }

    public static String lzw_compress(final String input) {
        // maps
        byte str_pos = -128; // starting position in byte to String map
        Map<Byte, String> stringMap = new HashMap<>(); // holds strings in values from -128 to 127

        for (int x=0; x<input.length(); x++) {
            stringMap.put(str_pos, String.valueOf(input.charAt(x)));
            str_pos++;
        }
        String compressed = "";

        String phrase = stringMap.get((byte) 0);

        for (int i=1; i<stringMap.size(); i++) {
            String current_char = stringMap.get((byte) i);

            // check if phrase is in Map
            String temp = phrase + current_char;
            if (inStringMap(temp, stringMap)) { // If it exists
                phrase = temp;
            } else { // If it doesnt exist within the Map
                str_pos++;
                phrase += current_char;
                System.out.println(str_pos + ": " + phrase);
                stringMap.put(str_pos, phrase);
            }
        }
        return compressed;
    }

    public static void main(String[] args) {
        System.out.println("LZW");
        String dave = lzw_compress(
                "On the twelfth day of Christmas, my true love sent to me," +
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
                        "A partridge in a pear tree");
        System.out.println(dave);
    }
}