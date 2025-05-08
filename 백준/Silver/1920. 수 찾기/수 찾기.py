# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
M = int(input())
Mnum = list(map(int, input().split()))
A.sort()


for i in range(M):
    mid = N // 2
    start = 0
    end = N-1
    check = False
    target = Mnum[i]

    while start <= end:
        mid = (start + end) // 2
        midv = A[mid]
        if midv < target:
            start = mid+1
        elif midv > target:
            end = mid - 1
        else:
            check = True
            break
    
    if check:
        print(1)
    else:
        print(0)
            
            