public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        /*
        	https://codility.com/demo/results/training7CSP3W-SCD/
        	Correctness: 100%
        	Task score: 100%
        */
        int N = A.length;
        int[] res = new int[N];
        if (N != 0) {
            //placesToMove stores how much indices each element is shifted right
            int placesToMove = K % N;
            for (int i = 0; i < N; i++) {
                //if the shift is in the limit of A we normally shift  
                if (i + placesToMove < N) {
                    res[i + placesToMove] = A[i];
                    continue;
                }
                //else we continue shifting the beggining of A 
                res[(i + placesToMove) % N] = A[i];
            }
        }
        return res;
    }
}
