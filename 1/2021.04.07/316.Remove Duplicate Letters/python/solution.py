class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        count = [0] * 26
        in_stack = [False] * 26
        for c in s:
            count[ord(c) - ord('a')] += 1
        for c in s:
            count[ord(c) - ord('a')] -= 1
            if in_stack[ord(c) - ord('a')]:
                continue
            while stack and stack[-1] > c and count[ord(stack[-1]) - ord('a')] > 0:
                in_stack[ord(stack.pop()) - ord('a')] = False
            stack.append(c)
            in_stack[ord(c) - ord('a')] = True
        return ''.join(stack)
