/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.

*/

class Solution {
  
  Map<Character, Integer> first;
  Map<Character, Integer> last;
  
  public List<Integer> partitionLabels(String S) {
    this.first = new HashMap<Character, Integer>();
    this.last = new HashMap<Character, Integer>();
    
    List<Integer> list = new ArrayList<>();
    
    for(int i = 0; i < S.length(); i++) {
      last.put(S.charAt(i), i);
    }
    
    int init = 0;
    int last = 0;
    int total = 0;
    
    while(total < S.length()) {
      last = this.last.get(S.charAt(init));
      int count = 1;
      // System.out.println("outer");
      while(init + count <= last) {
        int sec = this.last.get(S.charAt(init + count));
        // System.out.println("inner");
        if(sec > last){
          last = sec;
        }
        count++;
      }
      list.add(last-init + 1);
      total = last + 1;
      init = total;
      // System.out.println(init + "  " + last + "  " + total);
    }
    
    return list;
  }
}
