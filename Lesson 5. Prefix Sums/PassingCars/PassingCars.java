public class PassingCars {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/training2KA8NN-VCE/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 0;
        int N = A.length;
        int countZeros = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0)
                countZeros++;
            //when the element is 1 we add countZeros to res
            //because we have countZeros pairs
            else 
                res += countZeros;
            if (res > 1000000000)
                return -1;
        }
            
        return res;
    }
}
