package lc_000Sort._004_heapSorted;

public class Solution2 {
    public int[] heapSort(int[] arr){
        if(arr == null || arr.length == 0) return arr;
        int len = arr.length;
        // 构建大顶堆（想象成从第一个非叶子结点开始向上遍历使得每个根节点>=叶子结点，满足大顶堆）
        for(int i =len/2-1;i>=0;i--){
            heapfy(arr,i,len);
        }
        // 构建完以后，每次将最后一个位置数和第一个位置数交换;
        //  并且重新构建大顶堆，每次重构减少一个末尾已经排好的最大结点，
        //   从第一个位置不断与'子节点'位置的数比较交换，直到最后一个位置；
        for(int i = len-1;i>0;i--){
            swap(arr,0,i);
            heapfy(arr,0,--len);
        }
        return arr;
    }
    // 堆排序的核心代码；（调整堆位置，使其满足大顶堆）
    public void heapfy(int[] arr,int start,int end){
        // 先默认最大结点为start;
        int maxIndex = start;
        // left, right 表示左右结点位置；
        int left = start*2+1,right = left+1;
        // 比较左右节点位置的数和当前位置数大小（并更新maxIndex=三者最大的数位置）
        if(left < end && arr[left] > arr[maxIndex]){
            maxIndex = left;
        }
        if(right < end && arr[right] > arr[maxIndex]){
            maxIndex = right;
        }
        // 如果maxIndex != start 从maxIndex位置递归继续调整堆；
        //  否则结束，因为不需要调整堆位置；
        if(maxIndex != start){
            swap(arr,start,maxIndex);
            heapfy(arr,maxIndex,end);
        }
    }
    // 交换位置函数
    public void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
