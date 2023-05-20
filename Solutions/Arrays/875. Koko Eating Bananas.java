class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i:piles){
            if(i>max)max=i;
        }
       int lo=1,ans=max;
       while(lo<max){
           int mid=lo+(max-lo)/2;
           if(canEat(piles,mid, h)){
               max=mid;
               ans=mid;
           }
           else{
               lo=mid+1;
           }
           
       }
        return ans;
    }
    boolean canEat(int piles[],int mid, int h){

        int time=0;

        for(int i:piles){
           
            
                time+=i%mid==0?i/mid: i/mid +1;
           
        }
        return time<=h;
        
    }
}
