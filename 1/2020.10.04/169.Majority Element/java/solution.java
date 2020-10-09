class Solution {
    public int majorityElement(int[] nums) {
        // sort
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement(int[] nums) {
        // hash table
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length/2) {
                return num;
            }
        }
        throw new RuntimeException("no majority element found.");
    }

    public int majorityElement(int[] nums) {
        // boyer-moore 投票算法
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
