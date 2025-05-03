import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M = map(int, input().split())

stack = [[] for _ in range(N)]
visited = [False] * N
check = False
def dfs(v, depth):
    global check
    if depth >= 4:
        check = True
        return
        
    visited[v] = True

    for i in stack[v]:
        if visited[i] is False:
            dfs(i, depth+1)
    visited[v] = False
    

for i in range(M):
    v, e = map(int, input().split())
    stack[v].append(e)
    stack[e].append(v)

depth = 0
result = 0
for i in range(N):
    dfs(i, depth)
    if check:
        result = 1
        break

print(result)