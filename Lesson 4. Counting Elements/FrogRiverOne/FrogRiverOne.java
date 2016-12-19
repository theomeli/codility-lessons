import java.util.Stack;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        /*
            https://codility.com/demo/results/training5TAGSW-WVA/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 0;
        int N = A.length;
        boolean[] aux = new boolean[X];
        for (int i = 0; i < N; i++) { 
            //checks if the current element is one of the first X position and if it has been already parsed 
            if (A[i] <= X)
                if (!aux[A[i] - 1]) 
                    aux[A[i] - 1] = true;
                else
                    continue;
            //stores the last index of A with the desired property
            res = i;
        }
    
        //checks if every position till X has been parsed
        for (int i = 0; i < X; i++)
            if (!aux[i])
                return -1;
        
        return res;
    }
    
}
