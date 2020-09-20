public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left)
            return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);  
    }


    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;
        // 合并
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j]? arr[i++] : arr[j++];
        }
        //  剩余元素
        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= right)
            temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}


