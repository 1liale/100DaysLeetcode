package src;

import java.util.*;

// Hashmap solution:
// Time complexity: O(n), Space Complexity: O(n)
public class AllDisappearNumSol1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i] - 1, true);
        }

        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!seen.containsKey(i)) {
                output.add(i + 1);
            }
        }

        return output;
    }
    public static void main(String[]args){
        int[] testcase1 = {4,3,2,7,8,2,3,1};
        AllDisappearNumSol1 sol = new AllDisappearNumSol1();
        
        System.out.println(sol.findDisappearedNumbers(testcase1));
    }
    
}
