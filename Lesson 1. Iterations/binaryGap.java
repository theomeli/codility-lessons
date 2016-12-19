public class Lesson1 {
    
    public int solution(int N) {
        /*  
		 https://codility.com/demo/results/trainingWSSG54-U3J/
            Correctness: 100%
            Task score: 100%
        */
        
        //res is the length of current maximum binary gap
        int res = 0;
        //curRes is the length of currenrt binary gap
        int curRes = 0;
        String binaryString = Integer.toBinaryString(N);
        for (int i=1; i<binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') { 
                curRes++;
                continue;
            }        
            //if current character is 1 we refresh the variables res and curRes
            res = (curRes > res ? curRes : res);
            curRes = 0;
        }
        
        return res;
    }
}