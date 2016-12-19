public class TieRopes {

    public int solution(int K, int[] A) {
        /*
            https://codility.com/demo/results/trainingU9UMGN-C3H/
            Performance: 100%
            Correctness: 100%
            Task score: 100%
        */
        int res = 0;
        int N = A.length;
        int sum = 0;
        //using the greedy algorithm we sum consecutive elements until the sum is greater than or equal to K.
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (sum >= K) {
                res++;
                sum = 0;
            }
        }
        
        return res;
    }
}
