class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        
  int  n   = s.length();
        String ans =  "";
        for(int i = 0;i<n;i++){
            
            String sub =  "";
            
            int count = 0;
            for(int j = i;j<n;j++){
                count +=s.charAt(j)-'0';
                sub+=s.charAt(j);
                
                if(count==k){
                    
                    if (ans.equals("") || ans.length()>sub.length() || (ans.length()==sub.length()&&sub.compareTo(ans)<0))
                    ans =  sub;
                   break;
                    
                }
                
                
            }
        }
        return ans;
        
    }
}
