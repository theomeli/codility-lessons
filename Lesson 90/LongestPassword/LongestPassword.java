import java.util.ArrayList;

public class LongestPassword {

    public int solution(String S) {
        /*
            https://codility.com/demo/results/trainingSCWJYU-2HE/
            Correctness: 100%
            Performance: not assessed
            Task score: 100%
        */
        int res = 0;
        //we form an array with the given words
        String[] strings = S.split(" ");
        
        //we filter out the words with non alphanumerical characters 
        ArrayList<String> listWithAlphanumeric = new ArrayList<>();
        for (String s : strings) {
            if (s.matches("^[a-zA-Z0-9]*$")) 
                listWithAlphanumeric.add(s);
        }
        
        int countLetters = 0;
        int countNumbers = 0;
        ArrayList<String> toRemove = new ArrayList<>();
        //we parse each word and count its letters and numbers
        //when letters or numbers don't meet the restrictions we add the word to arrayList toRemove
        for (String s : listWithAlphanumeric) {
            String lower = s.toLowerCase();
            countLetters = 0;
            countNumbers = 0;
            for (int i = 0; i < lower.length(); i++) {
                if ((lower.codePointAt(i) >= 97 && lower.codePointAt(i) <= 122)) {
                    countLetters++;
                    continue;
                }
                if (lower.codePointAt(i) >= 48 && lower.codePointAt(i) <= 57)
                    countNumbers++;
            }
            if (countLetters % 2 == 1 || countNumbers % 2 == 0)
                toRemove.add(s);
        }
        
        //we remove the words of toRemove from arrayList listWithAlphanumeric 
        for (String s : toRemove) {
            for (String string : listWithAlphanumeric) {
                if (s == null ? string == null : s.equals(string)) {
                    listWithAlphanumeric.remove(string);
                    break;
                }
            }
        }
        
        if (listWithAlphanumeric.isEmpty())
            return -1;
        else
            //we find the longest accepted word
            for (String s : listWithAlphanumeric)
                if (s.length() > res)
                    res = s.length();
        
        return res;
    }
}
