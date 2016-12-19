import java.util.Arrays;

public class MissingInteger {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingEW845G-DEK/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //this solution offers a O(1) worst-case space complexity
        int N = A.length;
        int firstPositive = 0;
        Arrays.sort(A);
        //it finds the position of the first positive integer 
        for (int i = 0; i < N; i++) {
            if (A[i] > 0) {
                firstPositive = i;
                break;
            }
        }
        //checks the case that first positive is number 2
        int temp = A[firstPositive];
        if (A[firstPositive] != 1)
            return 1;
        
        //we parse elements of A starting from the index firstPositive and when find two consecutive
        //elements without differing by 1 return the result
        for (int i=firstPositive + 1; i < N; i++) {
            if (A[i] > temp + 1)
                return temp + 1;
            temp = A[i];
        }
              
        return A[A.length - 1] + 1 ;
    }
}
