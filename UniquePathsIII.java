/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/

On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Note:

1 <= grid.length * grid[0].length <= 20
*/

class Solution {
  
  int count;
  
  int[][] getCopy(int[][] arr) {
    int[][] newArr = new int[arr.length][arr[0].length];
    
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[0].length; j++) {
        newArr[i][j] = arr[i][j];
      }
    }
    
    return newArr;
  }
  
  void goToPath(int[][] arr, int i, int j, int length) {
    
    // System.out.println(Arrays.deepToString(arr));
    
    if(arr[i][j] == 2 && length == 1) {
          // System.out.println(length);
          // System.out.println(Arrays.deepToString(arr));

      this.count++;
      return;
    }
    int[][] copy = getCopy(arr);
    copy[i][j] = -1;
    
    if(i < arr.length - 1 && copy[i+1][j] != -1 )
      goToPath(copy, i + 1, j, length - 1);
    
    if(i > 0 && copy[i-1][j] != -1 )
      goToPath(copy, i - 1, j, length - 1);
    
    if(j < arr[0].length - 1 && copy[i][j+1] != -1 )
      goToPath(copy, i, j + 1, length - 1);
    
    if(j > 0 && copy[i][j-1] != -1 )
      goToPath(copy, i, j - 1, length - 1);
    
  }
  
  public int uniquePathsIII(int[][] grid) {
    count = 0;
    int i1 = -1;
    int j1 = -1;
    int i2 = -1;
    
    int x = 0;
    
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 1) {
          i1 = i;
          j1 = j;
        }
          
        if(grid[i][j] == 2) {
          i2 = i;
        }
        
        if(grid[i][j] == -1)
          x++;
      }
    }
    
    if(i1 == -1 || i2 == -1)
      return 0;
    
    int cells = (grid.length * grid[0].length) - x;
    // System.out.println(cells);
    goToPath(grid, i1, j1, cells);
    
    return this.count;
  }
}
