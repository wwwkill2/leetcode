import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums.length < 3) {
            return output;
        }
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l - 2; i++) {
            if (nums[i] > 0) {
                return output;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int ps = i+1;
            int pe = l-1;
            while (ps < pe) {
                int total = nums[ps] + nums[pe];
                if (total < target) {
                    ps++;
                } else if (total > target) {
                    pe--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(-target);
                    list.add(nums[ps]);
                    list.add(nums[pe]);
                    output.add(list);
                    while (ps < pe && nums[ps] == nums[ps+1]) {
                        ps++;
                    }
                    while (pe > ps && nums[pe] == nums[pe-1]) {
                        pe--;
                    }
                    ps++;
                    pe--;
                }
            }
        }
        return output;
    }
}