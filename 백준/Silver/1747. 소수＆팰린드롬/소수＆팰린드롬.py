# 코드를 작성해주세요
import sys
import math
input = sys.stdin.readline

N = int(input())

A=[0]*(10000001)

for i in range(2, len(A)):
    A[i] = i

for i in range(2, int(math.sqrt(len(A))+1)):
    if A[i] == 0:
        continue
    for j in range(i+i, len(A), i):
        A[j] = 0

for i in range(N, len(A)+1):
    if A[i] != 0 and str(i) == str(i)[::-1]:
        print(i)
        break
    

