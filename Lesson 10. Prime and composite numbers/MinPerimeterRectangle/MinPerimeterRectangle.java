public class MinPerimeterRectangle {

    public int solution(int N) {
        /*
            https://codility.com/demo/results/trainingZDQ284-8M3/
            Performance: 100%
            Correctness: 100%
            Task score: 100%
        */
        int res = Integer.MAX_VALUE;
        int i = 1;
        //if N = A * B and A = i then B = N / i
        while (i * i <= N) {
            if (N % i == 0) {
                int candidate = 2 * (i + N / i);
                res = Math.min(candidate, res);
            }
            i++;
        }
        
        return res;
    }
}
