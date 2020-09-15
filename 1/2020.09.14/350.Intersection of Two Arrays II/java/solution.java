class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.getOrDefault(nums2[i], 0) != 0) {
				list.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
    }

	public int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] res = new int[list.size()];
		for (i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
