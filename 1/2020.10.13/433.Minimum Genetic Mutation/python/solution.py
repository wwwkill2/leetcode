class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if not end or not bank or end not in bank:
            return -1
        bank = set(bank)
        q = [(start, 0)]
        visited = {start}
        while q:
            word, level = q.pop(0)
            for i in range(len(word)):
                for c in ['A', 'C', 'G', 'T']:
                    intermediate_word = word[:i] + c + word[i+1:]
                    if intermediate_word == end:
                        return level + 1
                    if intermediate_word not in visited and intermediate_word in bank:
                        q.append((intermediate_word, level+1))
                        visited.add(intermediate_word)
        return -1
