class Solution {
    public int splitNum(int num) {
         String s =  String.valueOf(num);
         char a[] =  s.toCharArray();
         Arrays.sort(a);

         String b = "";
         String c =  "";
         for(int i =0;i<s.length();i++){



             if(i%2==0){


                 b+=a[i];

             }
             else{

                 c+=a[i];

             }
         }

         return Integer.parseInt(b)+Integer.parseInt(c);
         
    }
}
