import java.util.Arrays;

public class Distinct {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingYCEW3U-DQN/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 1;
        int N = A.length;
        if (N == 0)
            return 0;
        //as Arrays implementation mentions 
        //http://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html#sort%28byte%5B%5D%29
        //sort has worst-case time complexity of N * log(N) 
        Arrays.sort(A);
        int j = A[0];
        //if the current array's element is different from the previous one 
        //we have to increment the resulting counter
        for (int i = 1; i < N; i++) {
            if (A[i] != j)
                res++;
            j = A[i];
        }
        
        return res;
    }
}
