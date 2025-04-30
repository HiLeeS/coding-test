# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N = int(input())
P = list(map(int, input().split()))
A = [0]*N

for i in range(1, N):
    index = 0
    value = P[i]
    for j in range(i-1, -1, -1):
        if P[i] > P[j]:
            index = j+1
            break
    for j in range(i, index, -1):
        P[j] = P[j-1]
    P[index] = value

A[0] = P[0]
for i in range(1, N):
    A[i] = A[i-1] + P[i]

sum = 0
for i in range(0,N):
    sum += A[i]
print(sum)   
        
        
            