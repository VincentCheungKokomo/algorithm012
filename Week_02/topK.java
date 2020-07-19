// 快排解决topk的问题
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return  new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数 （第k小的数）
        return quickSearch(arr, 0, arr.length-1, k-1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的元素
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j+1);
        }
        // 否则，根据下标j与k的大小关系来决定继续切分左端还是右端
        return j > k? quickSearch(nums, lo, j-1, k) : quickSearch(nums, j+1, hi, k); 
    }

    // 快排切分， 返回下标j，使得比nums[j]小的数都在j的左边， 比nums[j]大的数都在j的右边
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo]; // 记录第一个元素的值
        int i = lo, j = hi + 1;
        while (true) {
             // 向右找一个比v大的元素
            while (++i <= hi && nums[i] < v);
            // 向左找一个比v小的元素
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            // 交换两个位置的元素
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j]; // 与第一个元素交换位置
        nums[j] = v; // 把第一个元素放到最终位置
        return j;
    }
}

// 方法2 
// 保持堆的大小为k，然后遍历数组中的数字，遍历的时候做如下判断：
// 1. 若目前堆的大小小于k，将当前数字放入堆中
// 2. 否则判断当前数字与大根堆堆顶元素大大小关系，
// 如果当前数字比大根堆堆顶还大，这个数就直接跳过；
// 反之，如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length ==  0) {
            return new int[0];
        }
        // java 中提供了现成的PriorityQueue（默认小根堆）
        // 实现大根堆需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) { // 0 ～ k-1
                pq.offer(num); // 入队
            }else if (num < pq.peek()) { // 大根堆堆顶元素
                pq.poll(); //堆顶元素出队
                pq.offer(num); // 新元素入队
            }
        }
        // 返回堆中的元素
        int[] res = new int[pq.size()]; 
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }
}


class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<> ();
        for (int i = 0;  i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}

