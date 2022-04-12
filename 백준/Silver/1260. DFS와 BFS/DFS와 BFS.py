import sys
from collections import deque

def dfs(edge, v, visited):
    visited[v] = True
    print(v, end=' ')

    for g in edge:
        if v in g:
            for i in g:
                if visited[i] == False:
                    dfs(edge, i, visited)

def bfs(edge, v, visited):
    visited[v] = True
    deq = deque()
    deq.append(v)
    while deq:

        a = deq.popleft()
        print(a, end=' ')

        for g in edge:
            if a in g:
                for i in g:
                    if visited[i] == False:
                        visited[i] = True
                        deq.append(i)

N,M,V = map(int, sys.stdin.readline().split())

edge = [[] for _ in range(M)]
for i in range(M):
    edge[i]=list(map(int, sys.stdin.readline().split()))

edge = sorted(edge,key= lambda x:sorted([x[0],x[1]]))
visited = [False] * (N+1)
dfs(edge, V, visited)
print()
visited = [False] * (N+1)
bfs(edge, V, visited)