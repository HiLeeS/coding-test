# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N = int(input())
k = int(input())

start = 1
end = k
ans = 0

while start <= end:
    mid = (start+end) // 2
    count = 0

    #중앙값보다 작은 값 계산
    for i in range(1, N+1):
        count += min(int(mid/i), N) #작은 수 카운트 핵심 로직
    
    if count < k:
        start = mid + 1
    
    else:
        ans = mid
        end = mid - 1

print(ans)
