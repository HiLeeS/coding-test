
# 코드를 작성해주세요
N, M = map(int, input().split())
num = list(map(int, input().split()))

S = [0]
c = 0
for i in num:
    S.append(S[c] + i)
    c += 1

for j in range(M):
    x, y = map(int, input().split())
    print(S[y] - S[x-1])

