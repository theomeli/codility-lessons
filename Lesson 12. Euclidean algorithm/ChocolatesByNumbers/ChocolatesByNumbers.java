public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        /*
            https://codility.com/demo/results/trainingQXJ3KU-R2Z/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //we have to find the lcm of m and n which has time complexity O(log(m+n))
        //lcm(n, m) = (n*m)/gcd(n,m)
        int aux = 0;
        int aux_N = N;
        int aux_M = M;
        while (aux_N % aux_M != 0) {
            aux = aux_N % aux_M;
            aux_N = aux_M;
            aux_M = aux;
        }
        
        return N / aux_M;
    }
}
