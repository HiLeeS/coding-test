import sys
from collections import deque
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M, V = map(int, input().split())

A = [[] for _ in range(N+1)]
visited_1 = [False] * (N+1)
visited_2 = [False] * (N+1)

for _ in range(M):
    v, e = map(int, input().split())
    A[v].append(e)
    A[e].append(v)

def dfs(V):
    visited_1[V] = True
    print(V, end=' ')

    for i in A[V]:
        if visited_1[i] is False:
            dfs(i)

def bfs(V):
    deq = deque()
    deq.append(V)
    visited_2[V] = True

    while deq:
        now = deq.popleft()
        print(now, end=' ')

        for i in A[now]:
            if visited_2[i] is False:
                visited_2[i] = True
                deq.append(i)


for i in range(N+1):
    A[i].sort()


dfs(V)
print()
bfs(V)