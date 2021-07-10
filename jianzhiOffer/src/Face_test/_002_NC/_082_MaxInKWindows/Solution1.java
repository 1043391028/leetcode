package src.Face_test._002_NC._082_MaxInKWindows;

//   题目： 滑动窗口的最大值；
//    描述: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
//
//         例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
//                他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
//                  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
//                  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
//
//             窗口大于数组长度的时候，返回空

//   示例1
//         输入：
//               [2,3,4,2,6,2,5,1],3
//       返回值：
//                [4,4,6,6,6,5]

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 ||size>num.length || size == 0) return res;
        int l = 0,r = 0;
        // 记录窗口里面最大数的位置
        int maxIndex = 0;
        //  移动窗口，核心思路就是，时刻更新maxIndex,一直保持maxIndex为最大位置；
        while(r<num.length){
            if(num[r] >= num[maxIndex]) maxIndex = r;
            // r-sie+1 表示窗口左边界，maxIndex出窗口，需要更新maxIndex为窗口内最大坐标；
            if(r>size-1 && maxIndex<r-size+1){
                maxIndex = r;
                for(int i = r-1;i >= r-size+1;i--){
                    if(num[i] > num[maxIndex])
                        maxIndex = i;
                }
            }
            // 当 r>2 时，窗口满足条件，不断将最大值加入到结果链表；
            if(r>=size-1){
                res.add(num[maxIndex]);
            }
            r++;
        }
        return res;
    }
}
