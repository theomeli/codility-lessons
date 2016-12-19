import java.util.Stack;

public class Dominator {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingHYQQA4-YBZ/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //we follow the O(n) time complexity algorithm of reading material https://codility.com/media/train/6-Leader.pdf
        int res = -1;
        //stores the index of A that is possible to have a dominator
        int N = A.length;
        Stack s = new Stack();
        if (A.length > 0)
            s.add(A[0]);
        //when we parse an element that is equal to the top of the stack we push it
        //differently we pop it out
        for (int i = 1; i < N; i++) {
            if (s.isEmpty() || (A[i] == (int) s.peek())) 
                s.push(A[i]);
            else
                s.pop();
        }
       
        //we have to check if the remaining element in the stack is dominator
        //i.e. {2, 1, 1, 3, 4} at the end has the number 4 in the stack which is not the leader
        int count = 0;
        if (!s.isEmpty()) {
            int candidate = (int) s.pop();
            for (int i = 0; i < N; i++)
                if (A[i] == candidate)
                    count++;
            
            //if there is we store the first index where the dominator occurs
            if (count > ((double) N) / 2)
                for (int i = 0; i < N; i++) 
                    if (candidate == A[i]) {
                        res = i;
                        break;
                    }
        }
        
        return res;
    }
}
