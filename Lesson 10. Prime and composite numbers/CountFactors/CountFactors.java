public class CountFactors {

    public int solution(int N) {
        /*
            https://codility.com/demo/results/trainingNP2256-22V/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 0;
        if (N == 1)
            return 1;
        //we put the condition i * i > 0 to avoid overflows
        //i.e. it's sqrt(MAX_INT) = 46340.95 and 46340 * 46340 < MAX_INT but 36341 * 36341 = -2147479015
        for (int i = 1; i * i <= N && i * i > 0; i++) {
            if (N % i == 0)
                res += 2;
            if (i * i == N)
                res--;
        }
        
        return res;
    }
}
