import java.util.Arrays;

public class Triangle {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/training4Z97PG-CDH/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 0;
        int N = A.length;
        //we check the case where there are less than a triad of elements
        if (N < 3)
            return 0;
        Arrays.sort(A);
        for (int i = 0; i < N - 2; i++) {
            //we check the supplementary to the given solutions
            //if any one holds there is no triangle and we check the next triad
            //we do not use i.e A[i] + A[i + 1] because of overflow
            if (A[i] <= A[i + 2] - A[i + 1]) 
                continue;
            if (A[i] <= A[i + 1] - A[i + 2])
                continue;
            if (A[i + 1] <= A[i] - A[i + 2])
                continue;
            res = 1;
        }
        
        return res;
    }
}
