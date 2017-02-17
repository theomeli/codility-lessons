import java.util.Arrays;

public class PermCheck {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/training4U89R7-A5Z/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //this solution offers a O(1) worst-case space complexity
        int N = A.length;
        Arrays.sort(A);
        for (int i = 0; i < N; i++)
            if (A[i] != i + 1) {
                return 0;
            }
        return 1;
    }
}
