# 코드를 작성해주세요
import sys
input = sys.stdin.readline

n = int(input())

count = 1   #n을 나타내는 방법에는 n도 포함
sum = 1
start_index = 1
end_index = 1

while end_index != n:
    if sum == n:
        count += 1
        end_index += 1
        sum += end_index
    elif sum > n:
        sum -= start_index
        start_index += 1
    else:
        end_index += 1
        sum += end_index

print(count)

