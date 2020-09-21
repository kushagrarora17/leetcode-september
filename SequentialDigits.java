/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
      int[] base = new int[] {12,123,1234,12345,123456,1234567,12345678,123456789,Integer.MAX_VALUE};
      int[] adder =new int[] {11,111,1111,11111,111111,1111111,11111111,111111111};
      
      int factor = 10;
      int index = 0;
      
      List<Integer> list = new ArrayList<Integer>();
      
      while(low/factor >= 10){
        factor *= 10;
        index++;
      }
      
      int num = base[index];
      
      while(num <= high) {
        if(num >= low)
          list.add(num);
        
        if(num%10 == 9)
          num = base[++index];
        else
          num = num + adder[index];
      }
      
      return list;
    }
}
