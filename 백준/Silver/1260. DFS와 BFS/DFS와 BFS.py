import sys
from collections import deque

def dfs(edge, v,visited):
    visited[v] = True
    print(v,end=" ")
    for g in edge:
        if v in g:
            for i in range(2):
                if visited[g[i]] != True:
                    dfs(edge, g[i], visited)

def bfs(edge, v, visited):
    que = deque([v])
    visited[v] = True
    while que:
        s = que.popleft()
        print(s, end=' ')
        for g in edge:
            if s in g:
                for i in range(2):
                    if visited[g[i]] != True:
                        que.append(g[i])
                        visited[g[i]] = True

N, M, V = map(int, sys.stdin.readline().split())
edge = [[] for _ in range(M)]

for i in range(M):
    edge[i]=list(map(int, sys.stdin.readline().split()))

edge = sorted(edge,key= lambda x:sorted([x[0],x[1]]))
Visited = [False] * (N+1)
dfs(edge,V,Visited)
print()
Visited = [False] * (N+1)
bfs(edge,V,Visited)