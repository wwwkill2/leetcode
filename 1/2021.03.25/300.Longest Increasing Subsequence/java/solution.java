class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (res.isEmpty() || num > res.get(res.size() - 1)) {
                res.add(num);
            } else {
                int l = 0, r = res.size() - 1;
                int loc = r;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (res.get(mid) >= num) {
                        loc = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    } 
                }
                res.set(loc, num);
            } 
        }
        return res.size();
    }
}
