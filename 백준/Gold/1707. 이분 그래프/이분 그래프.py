# 코드를 작성해주세요
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
K = int(input())
isEven = True

def dfs(node):
    global isEven
    visited[node] = True
    for i in A[node]:
        if not visited[i]:
            #인접 노드는 같은 집합이 아니므로 다른 집합으로 처리
            check[i] = (check[node]+1)%2
            dfs(i)
        #이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프 아님
        elif check[node] == check[i]:
            isEven = False


for _ in range(K):
    N, E = map(int, input().split())
    A = [[] for _ in range(N+1)]
    visited = [False]*(N+1)
    check = [0] * (N+1)
    isEven = True
    
    for i in range(E):  #인접 리스트로 그래프 저장
        u, v = map(int, input().split())
        A[u].append(v)
        A[v].append(u)
    
    #주어진 그래프가 항상 1개가 아니므로 모든 노드 실행
    for i in range(1, N+1):
        if isEven:
            dfs(i)
        else:
            break
    
    if isEven:
        print("YES")
    else:
        print("NO")
    