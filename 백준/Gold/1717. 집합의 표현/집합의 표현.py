# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
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
    if a!=b:
        parent[b] = a

def checksame(a,b):
    a = find(a)
    b = find(b)
    if a==b:
        return True
    return False

for i in range(N+1):
    parent[i] = i

for _ in range(M):
    z, a, b = map(int, input().split())
    if z == 0:
        union(a,b)
        
    if z == 1:
        if checksame(a,b):
            print("YES")
        else:
            print("NO")
