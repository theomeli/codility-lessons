public class TennisTournament {

    public int solution(int P, int C) {
        /*
            https://codility.com/demo/results/training4NBN7U-TSS/
            Correctness: 100%
            Performance: not assessed
            Task score: 100%
        */
        int games = P / 2;
        return (games > C ? C : games);
    }
}
