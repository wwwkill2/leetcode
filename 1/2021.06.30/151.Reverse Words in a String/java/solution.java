class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                int j = i + 1;
                while (j < s.length()) {
                    if (s.charAt(j) == ' ') {
                        break;
                    } else {
                        j++;
                    }
                }
                list.add(s.substring(i, j));
                i = j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
