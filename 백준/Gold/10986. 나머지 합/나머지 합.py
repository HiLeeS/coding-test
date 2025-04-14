# 코드를 작성해주세요
import sys
input = sys.stdin.readline

n, m = map(int,input().split())
A = list(map(int, input().split()))
S = [0] * n #구간 합 배열
C = [0] * m # 구간 합 배열을 m으로 나눴을 때 나머지 0~m-1
S[0] = A[0]
answer = 0

for i in range(1, n):
    S[i] = S[i-1] + A[i]


for j in S:
    num = j % m
    if num == 0:
        answer += 1
    C[num] += 1

for i in C:
    if i >= 2:
        answer += i*(i-1) // 2

print(answer)



