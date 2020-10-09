class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + " " + obstacles[i][1]);
        }
        int res = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    if (!set.contains((x + dx[di]) + " " + (y + dy[di]))) {
                        x += dx[di];
                        y += dy[di];
                        res = Math.max(res, x*x + y*y);
                    }
                }
            }
        }
        return res;
    }
}
