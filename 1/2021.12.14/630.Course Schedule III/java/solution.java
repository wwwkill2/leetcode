class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                heap.offer(ti);
            } else if (!heap.isEmpty() && heap.peek() > ti) {
                total -= heap.poll();
                total += ti;
                heap.offer(ti);
            }
        }
        return heap.size();
    }
}
