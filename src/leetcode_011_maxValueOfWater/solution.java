package leetcode_011_maxValueOfWater;

//      题目： 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
//             垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
//              使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//             说明：你不能倾斜容器，且 n 的值至少为 2。

//      大致思路：从数组两端依次比较大小收缩，小的一边缩小，在此过程设置最大值并不断计算更新；
//                计算公式 底边长度（right - left）* Math.min(araay[left], array[right]);


public class solution {
    public int maxArea(int[] height) {
        int len = height.length -1 , i = 0;
        int res = 0;
        while(i < len){
            res = height[i] < height[len]? Math.max(res,(len - i)*height[i++]) :
                    Math.max(res,(len-i)*height[len--]);
        }
        return res;
    }

}
