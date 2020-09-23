/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3469/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE-1;
    
    int countA = 0;
    int countB = 0;
    
    for(int i = 0; i < nums.length; i++) {
      int num = nums[i];
      
      if(num == a){
        countA++;
      } else if(num == b) {
        countB++;
      } else if(countA == 0) {
        countA = 1;
        a = num;
      } else if(countB == 0) {
        countB = 1;
        b = num;
      } else {
        countA--;
        countB--;
      }
    }
    
    countA = 0;
    countB = 0;
    
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == a)
        countA++;
      
      if(nums[i] == b)
        countB++;
    }
    
    List<Integer> list = new LinkedList<Integer>();
    
    int freq = nums.length/3;
    
    if(countA > freq)
      list.add(a);
    
    if(countB > freq)
      list.add(b);
    
    return list;
  }
}
