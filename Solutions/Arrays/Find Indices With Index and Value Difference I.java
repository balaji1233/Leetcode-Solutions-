class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        
        
        int  n  =   nums.length;
        for(int i = 0;i<n;i++){
            
            for(int j = 0;j<n;j++){
                
                
                if(Math.abs(i-j)>=indexDifference && Math.abs(nums[i]-nums[j])>=valueDifference){
                    
                    int[]  ans =  new int[2];
                    ans[0] =  i;
                    ans[1] = j;
                    return ans;
                    
                }
            }
        }
        int[] ans  =  new int[2];
        ans[0]  =-1;
        ans[1] = -1;
        return ans; 
        
    }
}
