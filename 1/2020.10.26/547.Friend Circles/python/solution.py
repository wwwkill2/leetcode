class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        # DFS
        def DFS(i):
            for j in range(len(M)):
                if M[i][j] == 1 and not visited[j]:
                    visited[i] = 1
                    DFS(j)
        visited = [0 for _ in range(len(M))]
        count = 0
        for i in range(len(M)):
            if not visited[i]:
                visited[i] = 1
                DFS(i)
                count += 1
        return count

    def findCircleNum(self, M: List[List[int]]) -> int:
        # BFS
        visited = [0 for _ in range(len(M))]
        count, q = 0, []
        for i in range(len(M)):
            if not visited[i]:
                q.append(i)
                while q:
                    s = q.pop(0)
                    visited[s] = 1
                    for j in range(len(M)):
                        if M[s][j] == 1 and not visited[j]:
                            visited[j] = 1
                            q.append(j)
                count += 1
        return count
