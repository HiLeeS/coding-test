from collections import deque
import sys
input = sys.stdin.readline

V = int(input())
A = [[] for _ in range(V+1)]
visited = [False] * (V+1)

for i in range(1, V+1):
    listline = list(map(int, input().split()))
    k =  listline[0]
    index = 1
    while listline[index] != -1:
        E = listline[index]
        if E == -1:
            break
        N = listline[index+1]

        A[k].append((E, N))
        index += 2

distance = [0] * (V+1)

def bfs(n):
    visited[n] = True
    queue = deque()
    queue.append(n)

    while queue:
        now = queue.popleft()
  
        for i in A[now]:
            if visited[i[0]] is False:
                visited[i[0]] = True
                queue.append(i[0])
                distance[i[0]] = distance[now] + i[1]


bfs(1)

Max = 1
for i in range(2, V+1):
    if distance[Max] < distance[i]:
        Max = i

distance = [0] * (V+1)
visited = [False] * (V+1)
bfs(Max)
distance.sort()
print(distance[V])