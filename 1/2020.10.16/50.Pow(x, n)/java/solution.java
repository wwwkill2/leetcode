class Solution {

    Map<Integer, Double> memo = new HashMap<>();

    public double myPow(double x, int n) {
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        double res = pow(x, n / 2);
        res = res * res * (n % 2 == 0 ? 1 : x);
        memo.put(n, res);
        return res;
    }
}
