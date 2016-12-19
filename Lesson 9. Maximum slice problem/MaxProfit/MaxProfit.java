public class MaxProfit {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingW5E4C3-QE2/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int max_ending_here = 0;
        //we have to check if the array is not empty
        if (A.length > 0)
            max_ending_here = A[0];
        int max_so_far = 0;
        int N = A.length;
        //we will use Kadane's algorithm
        //max_ending_here stores the smallest element of array A
        //max_so_far stores the biggest difference between max_ending_here and the elements of A
        for (int i = 1; i < N; i++) {
            max_ending_here = (A[i] - max_ending_here > 0 ? max_ending_here : A[i]);
            max_so_far = (max_so_far > A[i] - max_ending_here ? max_so_far : A[i] - max_ending_here);
        }
             
        return max_so_far;
    }
}
