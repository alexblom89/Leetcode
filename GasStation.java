/**
 * https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Cost refers to amount of gas needed to reach the next station, not the cost of the gas.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0, remainsGas = 0, start = 0;
        int n = cost.length;

        for (int i = 0; i < n; i++) {

            int balance = gas[i] - cost[i];
            totalGas += balance;
            remainsGas += balance;
            if (remainsGas < 0) {
                start = i + 1;
                remainsGas = 0;
            }
        }

        if (totalGas < 0) start = -1;
        return start;
    }
}
