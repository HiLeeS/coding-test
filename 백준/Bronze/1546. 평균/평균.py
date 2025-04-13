# 코드를 작성해주세요
n = int(input())

scores = list(map(int, input().split()))    #띄어쓰기로 구분
M = max(scores)
sum = sum(scores)

print(sum * 100 / M / n)