public class TapeEquilibrium {

    public int solution(int[] A) {
        /*
            https://codility.com/demo/results/trainingJUDZF6-BWQ/
            Correctness: 100%
            Performance: 100%
        */
        int N = A.length;
        int rightSum = 0;
        int leftSum = 0;
        int difference = Integer.MAX_VALUE;
        //we sum all elements
        for (int i=0; i<N; i++) {
            rightSum += A[i];
        }
        
        //in each iteration we increase the left sum and decrease the right sum 
        //and examine if the absolute difference of them is smaller than the previous ones
        for (int i=0; i<N-1; i++) {
            rightSum -= A[i];
            leftSum += A[i];
            //difference = (Math.abs(rightSum - leftSum) < difference ? Math.abs(rightSum - leftSum) : difference);
            difference = Math.max(Math.abs(rightSum - leftSum), difference);
        }
        
        return difference;
    }
}
