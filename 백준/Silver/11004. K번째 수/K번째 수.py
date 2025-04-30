# 코드를 작성해주세요
N, K = map(int, input().split())
A = list(map(int, input().split()))

A.sort()
print(A[K-1])