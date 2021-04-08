package sort;

import java.util.Random;

/**
 * @author wangjiaming3
 * @Description TODO
 * @date 2021/4/8 11:10 上午
 */
public class MySort0408 {

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int num = nums[i];
            while (j >= 0) {
                if (nums[j] > num) {
                    nums[j + 1] = nums[j];
                    j--;
                } else {
                    break;
                }
            }
            nums[j + 1] = num;
        }
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }

    public static int[] mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int mid = start + (end - start) / 2;
        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid + 1, end);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                res[index++] = left[i++];
            } else {
                res[index++] = right[j++];
            }
        }
        while (i < left.length) {
            res[index++] = left[i++];
        }
        while (j < right.length) {
            res[index++] = right[j++];
        }
        return res;
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        // terminator
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        // random pivot
        Random random = new Random();
        int r = random.nextInt(end - start + 1) + start;
        int pivot = nums[r];
        nums[r] = nums[end];
        nums[end] = pivot;
        int i = start, j = start;
        while (j < end) {
            if (nums[j] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        return i;
    }
}

