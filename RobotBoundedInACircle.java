/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/

On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.
Example 3:

Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Note:

1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
      int current = 0;
      int x = 0;
      int y = 0;
      
      for(int i = 0; i < instructions.length(); i++) {
        if(instructions.charAt(i) == 'G') {
          switch(current) {
            case 0 : {
              y += 1;
              break;
            }
            case 1 : {
              x += 1;
              break;
            }
            case 2 : {
              y -= 1;
              break;
            }
            case 3 : {
              x -= 1;
              break;
            }
          }
        } else {
          if(instructions.charAt(i) == 'L')
            current += 1;
          else
            current -= 1;
          
          if(current > 3)
            current -= 4;
          
          if(current < 0)
            current += 4;
        }
      }
      
      return (x == 0 && y == 0) || current != 0;
    }
}
