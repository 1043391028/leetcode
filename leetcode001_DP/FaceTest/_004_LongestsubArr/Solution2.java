package FaceTest._004_LongestsubArr;

//  库函数： str1.contains(str2.substring())

public class Solution2 {

        /**
         * longest common substring
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public String LCS (String str1, String str2) {
            // write code here
            int len1 = str1.length(), len2 = str2.length();
            int start = 0, end = 1;
            String res = "";
            while(end<=len2){
                String str = str2.substring(start,end);
                if(str1.contains(str)){
                    res = str;
                }else{
                    start++;
                }
                end++;
            }
            return res;
        }

}
