# 코드를 작성해주세요
n = int(input())

scores = list(map(int, input().split()))    #띄어쓰기로 구분
M = max(scores)

result = 0
for i in scores:
    result += i / M * 100

print(result / n)