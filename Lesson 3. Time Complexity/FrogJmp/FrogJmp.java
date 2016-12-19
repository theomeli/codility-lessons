public class FrogJmp {

    public int solution(int X, int Y, int D) {
        /*
            https://codility.com/demo/results/trainingS52GNH-3FM/
            Correctness: 100%
            Performance: 100%
            Task score: 100%
        */
        double dist = Y - X;
        double d = dist / D;
        
        //if d rounds to d - 1 we want the number floor(d) + 1
        //differently we want d
        return  (int) (d > Math.floor(d) ? (int) Math.floor(d) + 1 : d); 
    }
}
