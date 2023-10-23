class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        
        
        int n  =  nums.length;
        long minVal =  Integer.MAX_VALUE,maxVal  = Integer.MIN_VALUE;
        int minIndex = -1,maxIndex  = -1;
        for(int i = 0;i<n;i++){
            
            if(i-indexDifference >=0){
                
                
                int lastIdx = i -indexDifference;
                long lastVal =  nums[lastIdx];
                if(lastVal<minVal){
                    minVal =  lastVal;
                    minIndex = lastIdx;
                    
                }
                if(lastVal>maxVal){
                    
                maxVal =lastVal;
                maxIndex = lastIdx;
                }
            }
            if(minIndex >=0){
                
                long diff =  Math.abs(minVal-nums[i]);
                if(diff>=valueDifference){
                    
                    
                    return new int[]  {minIndex,i};
                    
                }
                diff  = Math.abs(minVal - nums[i]);
                if(diff>=valueDifference){
                    
                    return new int[]  {minIndex,i};
                    
                }
                
                diff  = Math.abs(maxVal-nums[i]);
                if(diff>=valueDifference){
                    
                    return new int[]  {maxIndex,i};
                    
                }
            }
        }
        return new int[] {-1,-1};
    }
}
