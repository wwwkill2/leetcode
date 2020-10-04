class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (ten > 0) {
                if (five == 0) {
                    return false;
                }
                ten--;
                five--;
            } else if (five < 3) {
                return false;
            } else {
                five -= 3;
            }
        }
        return true;
    }
}
