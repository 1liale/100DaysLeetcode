package src;

public class ThirdMaxSol1 {
    // Time Complexity: O(n) Space Complexity: O(1)
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } 
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }  
        
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (int i = 0; i < nums.length; i++) {
            if (first == null || nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (first > nums[i] && (second == null) || nums[i] > second) {
                third = second;
                second = nums[i];
            } else if ((second != null && second>nums[i]) && (third==null || nums[i]>third)) {
                third = nums[i];
            }  
        }
        if (third != null) {
            return third;
        }
        return first;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 5};
        System.out.println(thirdMax(nums));
    }
}