package src;

import java.util.*;

// Time Complexity: O(n), Space Complexity: O(1)
public class ThirdMaxSol2 {
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } 
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }  

        TreeSet<Integer> maxSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            maxSet.add(nums[i]);
            if(maxSet.size() > 3) {
                maxSet.remove(maxSet.first());
            }
        }
        if (maxSet.size() == 3) {
            return maxSet.first();
        }
        return maxSet.last();
    }

    public static void main(String[] args) {     
        int[] nums = {1, 2, 2, 3, 3, 5};
        System.out.println(thirdMax(nums));    
    }
}