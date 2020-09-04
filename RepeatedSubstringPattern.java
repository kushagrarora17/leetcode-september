/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

class Solution {
  
  Integer[] f;
  char startChar;
  char endChar;
  
  Integer[] getFactors(int len) {
    List<Integer> factors = new ArrayList<>();
    
    for (int i = 1; i < len; i++) {
      if(len%i == 0)
        factors.add(i);
    }
    
    return factors.toArray(new Integer[0]);
  }
  
  boolean verify(String orig, String test) {
    int times = orig.length()/test.length();
    
    // System.out.println(orig + "       "+ test);
    
    StringBuilder str = new StringBuilder(orig.length());
    for(int i = 0; i < times; i++) {
      str.append(test);
    }
    
    return orig.equals(str.toString());
    
  }
  
  public boolean repeatedSubstringPattern(String s) {
    int length = s.length();
    this.f = getFactors(length);
    this.startChar = s.charAt(0);
    this.endChar = s.charAt(length - 1);
    
    // System.out.println(Arrays.toString(this.f));
    
    int initial = 1;
    if(this.startChar == this.endChar) {
      initial = 0;
    }
                        
    for (int i = initial; i < this.f.length; i++) {
      int currentLength = this.f[i];
      // System.out.println(currentLength);
      if(s.charAt(currentLength - 1) == this.endChar) {
        boolean result = verify(s, s.substring(0, currentLength ));
        if(result)
          return true;
      }
    }
    
    return false;
    
  }
}
