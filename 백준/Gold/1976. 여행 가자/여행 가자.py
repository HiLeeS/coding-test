# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
parent = [0]*(N+1)

def find(a):
    if a == parent[a]:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        parent[b] = a

def checksame(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    else:
        return False


for i in range(N+1):
    parent[i] = i

for i in range(N):
    line = list(map(int, input().split()))
    for j in range(len(line)):
        if line[j] == 1:
            union(i+1, j+1)

trip = list(map(int, input().split()))
ans = "YES"
for i in range(1, M):
    if not checksame(trip[i - 1], trip[i]):
        ans = "NO"
        break
        
print(ans)