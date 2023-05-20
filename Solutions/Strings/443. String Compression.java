class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        int count = 0;
        int res = 0;
        int index = 0;
        for(char ch : chars){
            if(prev == ch){
                count++;
            }
            else{
                if(count == 1){
                    res++;
                    chars[index++] = prev;
                }
                else{
                    res++;
                    chars[index++] = prev;
                    String tmp = Integer.toString(count);
                    
                    res+=tmp.length();
                    for(char tc : tmp.toCharArray()){
                        chars[index++] = tc;
                    }
                }
                prev = ch;
                count = 1;
            }
        }
        if(count == 1){
            res++;
            chars[index++] = prev;
        }
        else{
            res++;
            chars[index++] = prev;
            String tmp = Integer.toString(count);
            
            res+=tmp.length();
            for(char tc : tmp.toCharArray()){
                chars[index++] = tc;
            }
        }
        return res;
    }
}
