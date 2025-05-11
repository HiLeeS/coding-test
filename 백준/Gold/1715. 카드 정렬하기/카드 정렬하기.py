# 코드를 작성해주세요
from queue import PriorityQueue
import sys
input = sys.stdin.readline

myque = PriorityQueue()
N = int(input())

for i in range(N):
    myque.put(int(input()))
    
sum = 0
while myque.qsize() != 1:
    num1 = myque.get()
    num1 += myque.get()
    sum += num1
    myque.put(num1)

print(sum)
