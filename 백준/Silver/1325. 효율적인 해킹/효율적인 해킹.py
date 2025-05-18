# 코드를 작성해주세요
# 코드를 작성해주세요
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

C = [[] for _ in range(N+1)]
visited = [False]*(N+1)
check = [0]*(N+1)
ans = []


for i in range(M):
    A, B = map(int, input().split())
    C[B].append(A)

def bfs(n):
    myque = deque()
    visited[n] = True
    myque.append(n)
    while myque:
        now = myque.popleft()
        for i in C[now]:
            if visited[i] == False:
                visited[i] = True
                myque.append(i)
               
max = -1
for i in range(1, N+1):
    bfs(i)
    check[i] = visited.count(True)
    if max < check[i]:
        max = check[i]
    visited = [False]*(N+1)
    
for i in range(N+1):
    if max == check[i]:
        ans.append(i)

ans.sort()
for i in ans:
    print(i, end=' ')

