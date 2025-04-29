import sys
input = sys.stdin.readline

N = int(input())
A = []

max = 0

for i in range(N):
    A.append((int(input()), i))

A.sort()

for i in range(N):
    if max < A[i][1] - i:
        max = A[i][1] - i

print(max+1)