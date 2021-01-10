package leetcode_188_MaxProfitOfBuyAndSellSTack;

//  思路二：递归+记忆法；(优化测试还是超时)
//          思路一递归时间复杂度太大，实际上某一天买和不买被重复计算了多次；
//            因为第一天递归就计算了所有接下来每一天的买和不买的情况，第二天递归又重复计算了第二天以后的所有情况；
//   所以可以选择 递归+记忆的方法；将第一次递归遍历的所有情况记录下来，这样就节省了大量时间；
//
//   具体做法： 借助HashMap，记录遍历过的最大值；
//   另外需要注意： 如果 K >= len/2(len表示数组长度)，则可以当成是可以进行无数次交易，
//                  因为不能当天同时买入卖出，最多也就进行 len/2 次交易；
///

import java.util.HashMap;

public class Solution2 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        if(k >= len/2){
            // dp0 表示某一天未持有股票，dp1 表示某一天持有股票；
            // 初始化，第一天情况；
            int dp0 = 0, dp1 = -prices[0];
            // i = 1 表示第 2 天买卖股票的情况；循环到i = len-1 表示第len天（最后一天）买卖股票的情况；
            // 实际上每次循环就是代表第 i+1 天持有和未持有股票的最大值；
            //  在此过程中 每次循环的结果都是在上一次结果的基础上更新的结果；
            //    每次循环的选择都是最大的，选择以后对后面所有的结果产生影响；
            for(int i = 1;i<len;i++){
                dp0 = Math.max(dp0,dp1 + prices[i]);
                dp1 = Math.max(dp1,dp0 - prices[i]);
            }
            return dp0; // 最后最大值肯定是未持有股票的情况；
        }
        // 新建 HahsMap 保存遍历过的状态最大值Integer；
        HashMap<Key,Integer> map = new HashMap<Key, Integer>();
        return dfs(prices,0,0,0,k,map);
    }

    public int dfs(int[] prices,int day,int states,int count,int k,HashMap<Key,Integer> map){
        Key key = new Key(day,states,count);
        if(map.containsKey(key)) return map.get(key);
        if(day >= prices.length || (count == k && states== 0)){
            return 0;
        }
        // 递归进入某一天，有三种可能： 1.不动（既不买也不卖）;2.持有;3.持有.
        int a = 0,b = 0,c =0;// 分别对应三种情况；

        // 1.不动；直接进入下一层（下一天）；
        a = dfs(prices,day+1,states,count,k,map);
        // 2.未持有：可以买入，或者继续不持有（第一种状态：不动）；
        if(states == 0){
            b = -prices[day] + dfs(prices,day+1,1,count,k,map);
        }else{
            // 3.持有： 可以卖出，或者继续持有（第一种状态：不动）
            c = prices[day] + dfs(prices,day+1,0,count +1,k,map);
        }
        int max = Math.max(a,Math.max(b,c));
        // 更新map;
        map.put(key,max);
        // 最后返回三种情况的最大值；
        return max;
    }

    private class Key{
        private int day;
        private int states;
        private int count;

        Key(int day,int states,int count){
            this.count = count;
            this.day = day;
            this.states = states;
        }

        public int HashCode(){
            return count + states + day;
        }
        public boolean equals(Key obj){
            Key other = obj;
            return (count == other.count && day == other.day && states == other.states);
        }
    }
}
