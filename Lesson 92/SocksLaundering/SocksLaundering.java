public class SocksLaundering {

    public int solution(int K, int[] C, int[] D) {
        /*
            https://codility.com/demo/results/trainingS4RWMK-YU2/
            Correctness: 100%
            Performance: not assessed
            Task score: 100%
        */
        int res = 0;
        int N = C.length;
        int M = D.length;
        
        //find the maximal number of socket type in array C
        //and define an array of that size 
        //which will count the sockets of each type
        int maxClean = C[0];
        for (int i = 0; i < N; i++) {
            if (C[i] > maxClean)
                maxClean = C[i];
        }
        int[] typesInClean = new int[maxClean];
        
        //for each clean socket increment the associated position of typesInClean
        for (int i = 0; i < N; i++) {
            typesInClean[C[i] - 1]++;
        }
        
        //we add the pairs of sockets in array typesInClean to the result
        //we subtract the added pairs from typesInClean
        for (int i = 0; i < maxClean; i++) {
            res += typesInClean[i] / 2;
            typesInClean[i] = (typesInClean[i] % 2 == 0 ? 0 : 1);
        }
        
        //same as typesInClean
        int maxDirty = D[0];
        for (int i = 0; i < M; i++) {
            if (D[i] > maxDirty)
                maxDirty = D[i];
        }
        int[] typesInDirty = new int[maxDirty];
        
        for (int i = 0; i < M; i++) {
            typesInDirty[D[i] - 1]++;
        }
        
        int i = 0;
        //checks if any clean socket fits with any dirty socket while there is empty room in the laundry
        while (K > 0 && i < maxClean) {
            if (typesInClean[i] == 1 && i < maxDirty) {
                if (typesInDirty[i] >= 1) {
                    typesInDirty[i]--;
                    res++;
                    K--;
                }
            }
            i++;
        }
       
        i = 0;
        //checks if there are any pairs of dirty sockets which can be washed in the laundry
        while (K > 1 && i < maxDirty) {
            while (typesInDirty[i] / 2 > 0 && K > 1) {
                res++;
                K -= 2;
                typesInDirty[i] -= 2;
            }
            i++;
        }
        
        return res;
    }
}
