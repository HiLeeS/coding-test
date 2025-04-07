n, m = map(int, input().split())

arr =  [list(map(int, input().split())) for _ in range(n)]

for k in range(n):  #거치는 노드
    for i in range(n):  #행
        for j in range(n):  #열
            if arr[i][j] > (arr[i][k] + arr[k][j]):
                arr[i][j] = (arr[i][k] + arr[k][j])


for i in range(m):
    a, b, c = map(int, input().split())
    if arr[a-1][b-1] <= c:
        print("Enjoy other party")
    else:
        print("Stay here")