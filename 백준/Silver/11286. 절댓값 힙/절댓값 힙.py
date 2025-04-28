# 코드를 작성해주세요
from queue import PriorityQueue
import sys
input = sys.stdin.readline


N = int(input())

myque = PriorityQueue(maxsize=N)

for i in range(N):
    k = int(input())
    if k == 0 and myque.empty():
        print(0)
    elif k == 0 and myque.qsize() != 0:
        print(myque.get()[1])
    
    elif k < 0:
        temp = k * (-1)
        myque.put((temp, k))
    
    elif k > 0:
        myque.put((k,k))
