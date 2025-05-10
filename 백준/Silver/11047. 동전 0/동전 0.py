# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

A = []
for i in range(N):
    A.append(int(input()))

A.reverse()

count = 0

for i in A:
    if K >= i:
        count += K // i
        K = K % i
    
    if K == 0:
        break
    
print(count)