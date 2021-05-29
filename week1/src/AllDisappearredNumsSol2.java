package src;

import java.util.*;

// In-place solution: 
// Time Complexity: O(n), Space Complexity O(1)
class AllDisappearredNumsSol2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] > 0) {
                output.add(i + 1);
            }
        }
  
        return output;
    }
    public static void main(String[] args) {
        AllDisappearredNumsSol2 sol2 = new AllDisappearredNumsSol2();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(sol2.findDisappearedNumbers(nums));
    }
}
