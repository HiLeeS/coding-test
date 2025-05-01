import sys
input = sys.stdin.readline

N = int(input())

A = [0] * 10001

for i in range(N):
    A[int(input())] += 1

for i in range(10001):
    if A[i] != 0:
        for _ in range(A[i]):
            print(i)
