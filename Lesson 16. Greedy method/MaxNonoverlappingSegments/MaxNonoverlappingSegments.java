public class MaxNonoverlappingSegments {

    public int solution(int[] A, int[] B) {
        /*
            https://codility.com/demo/results/training7Y9VPA-2MP/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 1;
        int N = A.length;
        if (N == 0)
            return 0;
        int end = B[0];
        //if the end of an element is smaller than the start of its next one then we found an overlapping segment
        for (int i = 1; i < N; i++) {
            if (end < A[i]){
                res++;
                end = B[i];
            }
        }
        
        return res;
    }
}
