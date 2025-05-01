import sys
input = sys.stdin.readline

def merge_sort(s, e):
    global count
    if e - s < 1: return
    m = int(s+(e-s) / 2)
    merge_sort(s, m)
    merge_sort(m+1, e)
    for i in range(s, e+1):
        tmp[i] = A[i]
    
    k = s
    index1 =s
    index2 = m+1
    while index1 <= m and index2 <= e:  #두 그룹을 병합하는 로직
        if tmp[index1] > tmp[index2]:
            count += index2 - k
            A[k] = tmp[index2]
            k += 1
            index2 += 1
        else:
            A[k] = tmp[index1]
            k += 1
            index1 += 1
    while index1 <= m:  #한쪽 그룹이 모두 선택된 후 남아있는 값 정리
        A[k] = tmp[index1]
        k += 1
        index1 += 1

    while index2 <= e:
        A[k] = tmp[index2]
        k += 1
        index2 += 1

N = int(input())
A = [0] *(N+1)

b = list(map(int, input().split()))
for i in range(1, N+1):
    A[i] = b[i-1]

tmp = [0]*(N+1)

count = 0
merge_sort(1, N)


print(count)

