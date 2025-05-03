import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M = map(int, input().split())
stack = [[] for _ in range(N+1)]
visited = [False] * (N+1)

def dfs(v):
    visited[v] = True

    for i in stack[v]:
        if visited[i] is False:
            dfs(i)

for i in range(M):
    v, e = map(int, input().split())
    stack[v].append(e)
    stack[e].append(v)

count = 0
for i in range(1, N+1):
    if visited[i] is False:
        dfs(i)
        count += 1

print(count)