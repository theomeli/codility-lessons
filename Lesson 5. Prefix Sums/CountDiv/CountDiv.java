public class CountDiv {

    public int solution(int A, int B, int K) {
        /*
            https://codility.com/demo/results/training6BPF5R-ACV/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //start is the smallest number between A and B which is divisible by K
        int start = (A % K == 0 ? A : A + K - A % K);
        //end is the largest one
        int end = (B % K == 0 ? B : B - B % K);
        
        return (end - start) / K + 1;
    }
}
