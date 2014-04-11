package Leetcode;

public class GasStation {
	/* Accepted, my 1st attempt
	 * Brute force. Check routes starting from each gas station
	 * use remain to keep the remaining gas, add g[j] when it arrive jth station
	 * and minus cost[j] when it leave for j+1 station
	 * O(N^2) N stations * N iterate each after that
	 * Actually it's a little better than brute force cuz it terminate whenever
	 * remain < 0; which means it already skips the station which g[i]<c[i]*/
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        if(gas.length != cost.length) return -1;
//        //Brute force
//        for (int i=0; i<gas.length; i++){ // test the start point for each gas station
//            int remain = 0;
//            for (int j=i; j<gas.length+i; j++){
//                int index = round(j, gas.length);
//                remain += gas[index];
//                remain -= cost[index];
//                if (remain < 0) break;
//            }
//            if(remain >= 0) return i;
//        }
//        return -1;
//    }
//    
//    private int round(int n, int N){
//        if (n<N) return n;
//        return n%N;
//    }
    
    /* O(N) solution: only scan it once. 
     * if g[i] < c[i] i couldn't be the start point
     * if stop at j, then from i to j there is no start point
     * Expalin: because it would still be positive until j-1 (Otherwise it won't reach j)
     * That means i-j-1 is the largest positive number, start from i is the best we can do
     * but it still fails. No other starting point can be in this range*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length) return -1;
        int remain = 0;
        for (int startPoint = 0; startPoint <gas.length;startPoint++){
            remain = 0; // reset remain for each new startPoint
            if (gas[startPoint]>=cost[startPoint]){ // start from a valid startStation
            	for (int i=0; i<gas.length; i++){
            		remain += gas[round(startPoint+i, gas.length)] - cost[round(startPoint+i, gas.length)];
            		if (remain < 0){
            			startPoint = startPoint+i; // if it's larger than gas.length, then we've checked all possible starting point, no valid.
            			break;
            		}
            	}
            	if (remain >= 0) return startPoint;
            }
        }
        return -1;
    }
    
    private int round(int n, int N){
        if (n<N) return n;
        return n%N;
    }
    
    
}
