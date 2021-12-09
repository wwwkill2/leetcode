class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int totalArea = 0;
        Set<String> set = new HashSet<>();
        int left = Integer.MAX_VALUE, down = Integer.MAX_VALUE, right = Integer.MIN_VALUE, up = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            left = Math.min(left, rectangle[0]);
            down = Math.min(down, rectangle[1]);
            right = Math.max(right, rectangle[2]);
            up = Math.max(up, rectangle[3]);
            totalArea += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            List<String> points = new ArrayList<>();
            points.add(rectangle[0] + "," + rectangle[1]);
            points.add(rectangle[2] + "," + rectangle[3]);
            points.add(rectangle[0] + "," + rectangle[3]);
            points.add(rectangle[2] + "," + rectangle[1]);
            for (String point : points) {
                if (set.contains(point)) {
                    set.remove(point);
                } else {
                    set.add(point);
                }
            }
        }
        int maxArea = (right - left) * (up - down);
        if (maxArea != totalArea) {
            return false;
        }
        if (set.size() != 4) {
            return false;
        }
        List<String> points = new ArrayList<>();
        points.add(left + "," + down);
        points.add(left + "," + up);
        points.add(right + "," + down);
        points.add(right + "," + up);
        for (String point : points) {
            if (!set.contains(point)) {
                return false;
            }
        }
        return true;
    }
}
