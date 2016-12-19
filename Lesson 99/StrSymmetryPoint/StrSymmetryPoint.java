public class StrSymmetryPoint {

    public int solution(String S) {
        /*
            https://codility.com/demo/results/trainingBQDV9Q-ZY8/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int length = S.length();
        if (length == 0)
            return -1;
        //we split the string S to its two halves
        //we reverse the second half and check if it is equal to the first half
        String firstHalf = S.substring(0, length / 2);
        String secondHalf = S.substring(length / 2 + 1, length);
        secondHalf = new StringBuilder(secondHalf).reverse().toString();
        
        return (firstHalf.equals(secondHalf) ? length / 2 : -1);
    }
    
}
