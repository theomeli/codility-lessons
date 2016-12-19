public class MaxSliceSum {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingHUQF6V-5TS/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int N = A.length;
        //we will use Kadane's algorithm
        //max_ending stores the maximum sum for the current element 
        //max_slice stores the current maximum sum
        int max_ending = 0; int max_slice = -1000000;
        for (int i = 0; i < N; i++) {
            max_ending = Math.max(A[i], A[i] + max_ending);
            max_slice = Math.max(max_slice, max_ending);
        }
        return max_slice;
    }
}
