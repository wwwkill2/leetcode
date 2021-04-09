class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        List<Integer> dp = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int num = envelope[1];
            if (dp.isEmpty() || num > dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                int left = 0, right = dp.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) < num) {
                        left = mid + 1;
                    } else if (dp.get(mid) > num) {
                        right = mid - 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp.set(left, num);
            }
        }
        return dp.size();
    }
}
