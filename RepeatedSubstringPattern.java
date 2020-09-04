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
