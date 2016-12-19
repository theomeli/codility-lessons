import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        /*
            https://codility.com/demo/results/training3AHH9H-G58/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int count = 0;
        //in stack we store stonewalls that form blocks 
        Stack stack = new Stack();
        stack.push(H[0]);

        for (int i = 1; i < H.length; i++) {
            if (H[i] < H[i - 1]) {
                //while the current stonewall is shorter than the previous one and there is already a block 
                //which is taller than the current in the stack we increment the counter of blocks by one and we pop out the block 
                while(!stack.isEmpty() && (int) stack.peek() > H[i]) {
                    stack.pop();
                    count++;
                }
                
                //in the supplementary to the above situation, excluding the equality, we push the current stonewall in the stack
                if (stack.isEmpty() || H[i] > (int) stack.peek()) {
                    stack.push(H[i]);
                }
            //we similarly exclude the equality
            } else if (H[i] > H[i - 1]) {
                stack.push(H[i]);
            }
        }
        
        //result is given as the sum of blocks' counter with the stack's size
        return count + (int) stack.size();
        
    }
}