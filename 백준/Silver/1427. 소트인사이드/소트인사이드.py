# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N = list(input())
k = 0
max = 0
for i in range(len(N)):
    max = N[i]
    for j in range(i+1, len(N)):
        if max < N[j]:
            max = N[j]
            k = j
    
    if max > N[i]:
        N[k] = N[i]
        N[i] = max
        
for i in N:
    print(i, end='')