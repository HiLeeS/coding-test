
#D[i][j]의 값을 채우는 구간 합 공식
#D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]

#X1, Y1, X2, Y2에 대한 답을 구간 합으로 구하는 방법
#D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[0] * (N+1)]
D = [[0] * (N+1) for _ in range(N+1)]

for i in range(N):
    graph.append([0] + [int(x) for x in input().split()])

for i in range(1, N+1):
    for j in range(1, N+1):
        D[i][j] = D[i][j-1] + D[i-1][j] -D[i-1][j-1] + graph[i][j]  #2차원 합 배열 구하기

for j in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1])    #2차원 구간 합
