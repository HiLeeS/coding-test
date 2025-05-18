# 코드를 작성해주세요
import sys
from collections import deque
input = sys.stdin.readline

N, M, K, X = map(int, input().split())

A = [[] for _ in range(N+1)]
visited = [-1]*(N+1)

for i in range(M):
    s, e = map(int, input().split())
    A[s].append(e)

def bfs(n):
    myque = deque()
    visited[n] += 1
    myque.append(n)
    while myque:
        now = myque.popleft()
        
        for i in A[now]:
            if visited[i] == -1:
                myque.append(i)
                visited[i] = visited[now] + 1
    

bfs(X)
ans = []
for i in range(1, N+1):
    if visited[i] == K:
        ans.append(i)

if len(ans) == 0:
    print(-1)
else:
    ans.sort()
    for i in ans:
        print(i)

