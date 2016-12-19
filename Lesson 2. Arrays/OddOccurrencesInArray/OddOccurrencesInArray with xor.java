public class OddOccurrencesInArray {

    public int solution(int[] A) {
        //http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element/
        /*
            https://codility.com/demo/results/trainingV3FRMT-QSW/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int N = A.length;
        int xor = 0;
        for (int i = 0; i < N; i++)
            xor ^= A[i];
        return xor;
    }
    
}
