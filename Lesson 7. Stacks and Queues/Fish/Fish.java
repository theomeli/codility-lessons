import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {
        /*
            https://codility.com/demo/results/trainingBW7MM8-8TN/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int N = A.length;
        //it counts the fish which are upstream
        int upstreamFish = 0;
        //it stores the indices where the fish are downstream
        Stack downstream = new Stack();
        for (int i = 0; i < N; i++) {
            //if the current fish is upstream and there was no downstream fish previously
            if (B[i] == 0 && downstream.size() == 0) {
                upstreamFish++;
            }
            //the current fish is upstream and there is at least one downstream fish
            else if (B[i] == 0 && downstream.size() > 0) {
                //the current upstream fish eats previously downstreaming fish
                while (downstream.size() > 0 && A[i] > A[(int) downstream.peek()]) 
                    downstream.pop();
                //there is no downstream fish in the stack
                if (downstream.size() == 0)
                    upstreamFish++;
            }
            //the current fish is downstream
            else
                downstream.add(i);           
        }
        
        return downstream.size() + upstreamFish;
    } 
}