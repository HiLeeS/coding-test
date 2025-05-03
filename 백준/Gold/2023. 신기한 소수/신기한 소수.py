import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N = int(input())

def prime(num):
    for i in range(2, int(num/2+1)):
        if num % i == 0:
            return False
    return True


def dfs(v):
    if len(str(v)) == N:
        print(v)
    
    else:
        for i in range(1, 10):
            if i % 2 == 0:
                continue
            if prime(v * 10 + i):
                dfs(v*10 + i)


dfs(2)
dfs(3)
dfs(5)
dfs(7)

