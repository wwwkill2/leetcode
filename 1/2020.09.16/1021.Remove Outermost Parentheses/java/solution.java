class Solution {
    public String removeOuterParentheses(String S) {
        // using stack
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses(String S) {
        // single pointer
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && count++ > 0) {
                sb.append(c);
            } else if (c == ')' && count-- > 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
