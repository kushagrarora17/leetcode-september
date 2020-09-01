/*
https://leetcode.com/problems/largest-time-for-given-digits/

Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
*/

class Solution {
  
  void permute(int[] arr, int l, int r, List<int[]> list) {
    if (l == r) {
      list.add(arr.clone());
    }
    else
    { 
      for (int i = l; i <= r; i++) 
      { 
        swap(arr,l,i); 
        permute(arr, l+1, r, list); 
        swap(arr,l,i); 
      } 
    } 
  }
  
  void swap(int[] a, int i, int j) {
    int temp = a[i] ; 
    a[i] = a[j]; 
    a[j] = temp;
  }
  
  boolean isValid(int[] arr) {
    boolean flag = true;
    
    int hour = 10*arr[0] + arr[1];
    int min = 10*arr[2] + arr[3];
    
    if(hour > 23 || min > 59)
      flag = false;
    
    return flag;
  }
  
  public String largestTimeFromDigits(int[] A) {
    List<int[]> list = new ArrayList<int[]>();
    
    permute(A, 0, 3, list);
    
    
    
    list.removeIf(arr -> !isValid(arr));
    for(int[] a : list) {
      System.out.println(Arrays.toString(a));
    }
    int max = -1;
    String maxTime = "";
    
    for(int[] a : list) {
      int time = 60*(10*a[0] + a[1]) + (10*a[2] + a[3]);
      if(time > max) {
        max = time;
        maxTime = ""+a[0]+a[1]+":"+a[2]+a[3];
      }
    }
    return maxTime;
  }
}
