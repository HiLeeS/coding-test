# 코드를 작성해주세요
M, N = map(int, input().split())
visited = [False] * (N+1)
prime = []

for i in range(2, N+1):
    if visited[i] is False:
        prime.append(i)
    
    for j in range(i, N+1, i):
        if visited[j] is False:
            visited[j] = True
    
for i in prime:
    if i >= M and i <= N:
        print(i)