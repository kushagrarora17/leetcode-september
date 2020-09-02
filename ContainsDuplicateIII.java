/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      int len = nums.length;
      
      if(t == 0) {
        Arrays.sort(nums);
        for(int i = 0; i < len-1; i++) {
          if(nums[i] == nums[i+1])
            return true;
        }
        return false;
      }
      
      for(int i = 0; i < len-1; i++) {
        int limit = Math.min(i+1+k, len);
        for(int j = i+1; j < limit; j++) {
          if(Math.abs((long)nums[i] - (long)nums[j]) <= t)
            return true;
        }
      }
      
      
      
      return false;
    }
}
