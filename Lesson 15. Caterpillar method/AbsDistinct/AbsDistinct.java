import java.util.Arrays;

public class AbsDistinct {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingHKSNVT-VMQ/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //this solution doesn't use the caterpillar method and has space complexity O(1)
        int count = 1;
        int N = A.length;
        //we transform any negative element of A to its absolute value
        for (int i = 0; i < N; i++) {
            if (A[i] < 0)
                A[i] = Math.abs(A[i]);
        }
        
        //we sort the elements of A and we count the distinct values
        Arrays.sort(A);
        int prevDiff = A[0];
        for (int i = 1; i < N; i++) {
            if (A[i] != prevDiff) {
                count++;
                prevDiff = A[i];
            }
        }
        
        return count;
    }
}
