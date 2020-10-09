from collections import defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # BFS
        if not endWord or not wordList or endWord not in wordList:
            return 0
        n = len(beginWord)
        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(n):
                all_combo_dict[word[:i] + '*' + word[i+1:]].append(word)
        
        q = [(beginWord, 1)]
        visited = {beginWord: True}
        while q:
            current_word, length = q.pop(0)
            for i in range(n):
                intermediate_word = current_word[:i] + '*' + current_word[i+1:]
                for word in all_combo_dict[intermediate_word]:
                    if word == endWord:
                        return length + 1
                    if word not in visited:
                        q.append((word, length + 1))
                        visited[word] = True
                all_combo_dict[intermediate_word] = []
        return 0

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # double DFS
        def visit_word(q, visited, other_visited):
            current_word, length = q.pop(0)
            for i in range(n):
                intermediate_word = current_word[:i] + '*' + current_word[i+1:]
                for word in all_combo_dict[intermediate_word]:
                    if word in other_visited:
                        return length + other_visited[word]
                    if word not in visited:
                        q.append((word, length+1))
                        visited[word] = length+1
            return None

        if not endWord or not wordList or endWord not in wordList:
            return 0
        n = len(beginWord)
        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(n):
                all_combo_dict[word[:i] + '*' + word[i+1:]].append(word)

        q_begin = [(beginWord, 1)]
        q_end = [(endWord, 1)]
        visited_begin = {beginWord: 1}
        visited_end = {endWord: 1}

        while q_begin and q_end:
            res = visit_word(q_begin, visited_begin, visited_end)
            if res:
                return res
            res = visit_word(q_end, visited_end, visited_begin)
            if res:
                return res
        return 0
