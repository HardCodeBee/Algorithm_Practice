import java.util.HashMap;

class Solution {

    // Approach 1: Two Pointer Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // This approch is not typical two pointer actually, because the array is not sorted.

    public int[] twoSum1(int[] nums, int target) {
       int pointer1 = 0;
        int pointer2 = nums.length - 1;
        while(pointer1< pointer2){
            while(pointer1 < pointer2){
                if(nums[pointer1] + nums[pointer2] == target){
                    return new int[]{pointer1, pointer2};
                }
                else{
                    pointer2--;
                }
            }
            pointer1++;
            pointer2 = nums.length - 1;
        }
        return new int[]{};   
    }

    // Approach 2: HashMap
    // Time Complexity: O(n)    
    // Space Complexity: O(n)
    // This is the One-pass HashMap approach.
    //Idea like: Have I already seen a number that can pair with the current number to make the target?
    public int[] twoSum2(int[] nums, int target) {
        int pointer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(pointer< nums.length){
            int sub = target - nums[pointer];
            if(map.containsKey(sub)){
                return new int[]{map.get(sub), pointer};
            }
            else{
                map.put(nums[pointer], pointer);
            }
            pointer++;
        }
        return new int[]{};   
    }
}