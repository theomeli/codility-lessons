import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        /*
            https://codility.com/demo/results/trainingGYSX8D-NRH/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        int res = 1;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            //if the character is ')' and the stack is not empty, pop the top element out
            if (c == ')' && !s.isEmpty()) {
                if (s.peek() == '(')
                    s.pop();
            }
            //differently add the character to the stack 
            else
                s.add(c);            
        }
        
        if (!s.isEmpty())
            return 0;
        
        return res;
    }
}
