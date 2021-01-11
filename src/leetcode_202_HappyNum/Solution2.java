package leetcode_202_HappyNum;


//  思路二： HashSet法；
//

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = recountN(n);
        }
        return n == 1;
    }
    public int recountN(int n){
        int count = 0;
        while(n > 0){
            int k = n%10;
            count += k*k;
            n /=10;
        }
        return count;
    }
}
