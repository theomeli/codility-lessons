import java.util.Arrays;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingHKWHND-CA7/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int counter = 1;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            //counts the number of equal elements
            //if this number is odd this element is returned
            if (A[i - 1] == A[i])
                counter++;
            else {
                if (counter % 2 != 0)
                    return A[i - 1];
                else
                    counter = 1;
            }
        }    
        return A[A.length - 1];
    }
    
}
