import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingFCTZGN-T38/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int N = A.length;
        Arrays.sort(A); 
        //checks the case when the missing number is strictly between 1 and N + 1
        for (int i = 0; i < N; i++)
            if (A[i] != i + 1)
                return i + 1;
        
        //checks the case the missing number is N + 1 or 1
        if (N != 0)
            return (A[0] == 1 ? N + 1 : 1);
        //the remaining case is that of an empty array
        return 1;
    }
}
