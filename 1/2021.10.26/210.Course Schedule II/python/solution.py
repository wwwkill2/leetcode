class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # DFS
        def DFS(i):
            if visited[i] == 1:
                return True
            if visited[i] == 2:
                return False
            visited[i] = 1
            for j in graph[i]:
                if DFS(j):
                    return True
            res.append(i)
            visited[i] = 2
            return False

        graph = [[] for _ in range(numCourses)]
        for pre in prerequisites:
            graph[pre[0]].append(pre[1])
        visited = [0] * numCourses
        res = []
        for i in range(numCourses):
            if DFS(i):
                return []
        return res

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # Kahn
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for pre in prerequisites:
            graph[pre[1]].append(pre[0])
            indegree[pre[0]] += 1
        q, res = [], []
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
        while q:
            i = q.pop(0)
            res.append(i)
            for j in graph[i]:
                indegree[j] -= 1
                if indegree[j] == 0:
                    q.append(j)
        if len(res) != numCourses:
            return []
        return res
