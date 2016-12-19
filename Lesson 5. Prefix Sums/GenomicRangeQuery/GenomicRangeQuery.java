public class GenomicRangeQuery {

    //we use enumeration for better associating the nucleotides with their impact factors
    public enum Nucleotide {
        A, C, G, T;
    } 
    
    public int[] solution(String S, int[] P, int[] Q) {
        /*
            https://codility.com/demo/results/training8H8BAJ-P84/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int N = S.length();
        int M = P.length;
        //we use four arrays for the four types of nucleotides where in each element 
        //we sum the specific type of nucleotide at the current and previous positions of S
        //we have to use substring(i, i + 1) for 1 <= i < N and that is the reason of using arrays of size N + 1
        int[] sumOfAs = new int[N + 1];
        int[] sumOfCs = new int[N + 1];
        int[] sumOfGs = new int[N + 1];
        int[] sumOfTs = new int[N + 1];
        int[] res = new int[M];
        
        //enumerations start to count by 0, so we have to add 1
        int n = Nucleotide.valueOf(S.substring(0, 1)).ordinal() + 1;
        switch(n) {
            case 1:
                sumOfAs[1]++;
                break;
            case 2:
                sumOfCs[1]++;
                break;
            case 3:
                sumOfGs[1]++;
                break;
            case 4:
                sumOfTs[1]++;
                break;
        }
        
        for (int i = 1; i < N; i++) {
            int ns = Nucleotide.valueOf(S.substring(i, i + 1)).ordinal() + 1;
            sumOfAs[i + 1] = sumOfAs[i];
            sumOfCs[i + 1] = sumOfCs[i];
            sumOfGs[i + 1] = sumOfGs[i];
            sumOfTs[i + 1] = sumOfTs[i];
            switch(ns) {
                case 1:
                    sumOfAs[i + 1]++;
                    break;
                case 2:
                    sumOfCs[i + 1]++;
                    break;
                case 3:
                    sumOfGs[i + 1]++;
                    break;
                case 4:
                    sumOfTs[i + 1]++;
                    break;
            }
        }
        
        //for each query we check if the sums of nucleotides have been incremented
        //we start checking by the types with the smallest impacts
        //if so we found the result for the particular query
        //else we check if the query is about a single-character string
        for (int i = 0; i < M; i++) {
            if (sumOfAs[Q[i] + 1] - sumOfAs[P[i]] > 0)
                res[i] = 1;
            else if (sumOfCs[Q[i] + 1] - sumOfCs[P[i]] > 0)
                res[i] = 2;
            else if (sumOfGs[Q[i] + 1] - sumOfGs[P[i]] > 0)
                res[i] = 3;
            else if (sumOfTs[Q[i] + 1] - sumOfTs[P[i]] > 0)
                res[i] = 4;
            
            if (P[i] == Q[i])
                res[i] = Nucleotide.valueOf(S.substring(P[i], P[i] + 1)).ordinal() + 1;
        }
        
        return res;
    }
}
