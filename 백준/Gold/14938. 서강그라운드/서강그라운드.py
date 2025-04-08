n, m, r = map(int, input().split())

items = list(map(int, input().split()))

ground = [[16]*n for i in range(n)]

for _ in range(r):
    i, j, k = map(int, input().split())
    ground[i-1][j-1] = k
    ground[j-1][i-1] = k

for i in range(n):
    ground[i][i] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            if ground[i][j] > ground[i][k] + ground[k][j]:
                ground[i][j] = ground[i][k] + ground[k][j]

final_score = [0] * n
for i in range(n):
    for j in range(n):
        if ground[i][j] <= m:
            final_score[i]+=items[j]


print(max(final_score))
