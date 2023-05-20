class Solution {
    // binary search!
    public long minimumTime(int[] time, int totalTrips) {
        long result = 0;
        // low starts from 1 since min of both time[i] and totalTrips is 1.
        long low = 1;
        // high ends with 10^14 since the Max value for time[i] and totalTrips are 10^7.
        // so the worst case is when a bus takes 10^7 seconds for a trip, and need to finish 10^7 trips.
        // Thus, it's 10^7 * 10^7 = 10^14
        long high = 100000000000000L;
        
        // if low = high it means that there is only one number in our range, so found
        while (low <= high) {
            long mid = low + (high - low) / 2;
            boolean pass = isValid(time, mid, totalTrips);
            
            if (pass) {
                // can finish, so store for possible better solution    
                result = mid;
                high = mid - 1;
            } else {
                // no enough time, so go up for a valid solution
                low = mid + 1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] time, long mid, int totalTrips){
        long finish = 0;
        for (int each : time) {
            finish += mid / each;
            if (finish >= totalTrips) { return true; }
        }
        return false;
    }
}
