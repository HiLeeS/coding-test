# 코드를 작성해주세요
import sys
input = sys.stdin.readline

N = int(input())

def gcd(n1, n2):
    if n2 == 0:
        return n1
    else:
        return gcd(n2, n1%n2)   

for i in range(N):
    n1, n2 = map(int, input().split())
    ans = (n1 * n2) / gcd(n1, n2)
    print(int(ans))