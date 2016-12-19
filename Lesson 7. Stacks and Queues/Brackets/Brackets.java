import java.util.Stack;

public class Brackets {

    public int solution(String S) {
        /*
            https://codility.com/demo/results/trainingDNHH9A-2E7/
            Correctness: 100%
            Performance: 100%
			Task score: 100%
        */
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i); 
            //if we parse an open-character we store in the stack
            if (c == '{' || c == '[' || c == '(')
                s.add(c);
            //if we parse a close-character and the top of the stack has the associated open-character we pop
            //if this is not the case, it will be at least the unmatched characters in the stack at the end of parsing
            //finally checking if the stack is empty gives the desired result
            else if (c == '}' && !s.isEmpty()) {
                if (s.peek() == '{')
                    s.pop();
            }
            else if (c == ']' && !s.isEmpty()) {
                if (s.peek() == '[')
                    s.pop();
            }
            else if (c == ')' && !s.isEmpty()) {
                if (s.peek() == '(')
                    s.pop();
            }
            else
                return 0;
        }
        
        return (s.isEmpty() ? 1 : 0);
    }
}
