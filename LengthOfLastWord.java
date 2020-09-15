/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

class Solution {
  public int lengthOfLastWord(String s) {
    int ans = 0;
    
    char[] arr = s.toCharArray();
    
    int i = arr.length - 1;
    
    if(arr.length == 0)
      return 0;
    
    boolean wordStarted = false;
    
    while(i >= 0) {
      char current = arr[i];
      if(current == ' ') {
        if(wordStarted)
          break;
        else{
          i--;
          continue;
        }
      } else {
        wordStarted = true;
        ans++;
        i--;
      }
    }
    
    
    return ans;
  }
}
