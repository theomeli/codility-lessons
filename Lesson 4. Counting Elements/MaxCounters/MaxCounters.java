public class MaxCounters {

    public int[] solution(int N, int[] A) {
        /*
            https://codility.com/demo/results/trainingKVU84V-5CD/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int[] res = new int[N];
        //stores the current incremented value of array res
        int currentIncrease = 0; 
        //max value in the array res
        int max = 0;
        //the value to add after a maximizing operation
        int valueToAdd = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                //if there was a maximizing operation we have to check if the appropriate value has been added
                if (res[A[i] - 1] < valueToAdd)
                    res[A[i] - 1] = valueToAdd;
                currentIncrease = ++res[A[i] - 1];
                //checks if the current increase gives a maximal value
                if (currentIncrease > max)
                    max = currentIncrease;
            }
            else {
                valueToAdd = max;
            }
        }
        
        //checks if there are counters smaller than the maximal value
        //this may happen if after a maximizing operation any counters have not incremented till the end of parsing array A
        for (int i = 0; i < N; i++) {
            if (res[i] < valueToAdd)
                res[i] = valueToAdd;
        }
        
        return res;
    }
    
}
