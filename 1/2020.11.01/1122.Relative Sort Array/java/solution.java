class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // bucket sort
        int[] bucket = new int[1001];
        for (int num : arr1) {
            bucket[num]++;
        }
        // use arr1 itself
        int index = 0;
        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                arr1[index++] = num;
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
