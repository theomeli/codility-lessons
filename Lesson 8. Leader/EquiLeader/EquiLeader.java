import java.util.Stack;

public class EquiLeader {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingBPDPM9-XQG/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        //it is proved that an equileader exists iff (if and only if) exists a leader in the whole array
        int res = 0;
        int N = A.length;
        Stack s = new Stack();
        //we firstly find the leader of the whole array according to the reading material
        s.add(A[0]);
        for (int i = 1; i < N; i++) {
            if (!s.isEmpty()) {
                if ((int) s.peek() != A[i])
                    s.pop();
                else
                    s.add(A[i]);
            }
            else
                s.add(A[i]);
        }
        
        int leader = 0;
        if (!s.isEmpty())
            leader = (int) s.get(s.size() - 1);
        else
            return 0;
        
        int countLeaders = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == leader)
                countLeaders++;
        }
        
        //we divide the elements of the array in two parts 
        //and we count the leaders in each part with two variables leftLeaders, rightLeaders
        //when leftLeaders and rightLeaders meet the requirements for having leaders the relative subarrays
        //we increment the returned value of res
        int leftLeaders = 0;
        int rightLeaders = countLeaders;
        for (int i = 0; i < N; i++) {
            if (A[i] == leader) {
                leftLeaders++;
                rightLeaders--;
            }
            if (leftLeaders > (i + 1) / 2 && rightLeaders > (N - i - 1) / 2)
                res++;
        }
        
        return res;
    }
}
