import sys
input = sys.stdin.readline


N = int(input())
A = list(map(int, input().split()))

stack = []
ans = [0]*N

for i in range(N):
    while stack and A[stack[-1]] < A[i]:
        ans[stack.pop()] = A[i]
    stack.append(i)

while stack:
    ans[stack.pop()] = -1

for i in ans:
    print(i, end=' ')