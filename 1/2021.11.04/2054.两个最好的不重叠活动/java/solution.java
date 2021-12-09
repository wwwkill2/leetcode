class Solution {
    public int maxTwoEvents(int[][] events) {
        List<Event> list = new ArrayList<>();
        for (int[] event : events) {
            list.add(new Event(event[0], 0, event[2]));
            list.add(new Event(event[1], 1, event[2]));
        }
        Event[] arr = list.toArray(new Event[0]);
        Arrays.sort(arr, (a, b) -> a.ts == b.ts ? a.op - b.op : a.ts - b.ts);
        int res = 0, best = 0;
        for (Event event : arr) {
            if (event.op == 0) {
                res = Math.max(res, best + event.val);
            } else {
                best = Math.max(best, event.val);
            }
        }
        return res;
    }
}

class Event {
    public int ts;
    public int op;
    public int val;

    public Event(int ts, int op, int val) {
        this.ts = ts;
        this.op = op;
        this.val = val;
    }
}
