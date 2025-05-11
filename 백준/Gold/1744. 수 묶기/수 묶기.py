# 코드를 작성해주세요
import sys
from queue import PriorityQueue
input = sys.stdin.readline

N = int(input())
pluspq = PriorityQueue()
minuspq = PriorityQueue()
one = 0
zero = 0

for i in range(N):
    data = int(input())
    if data == 1:
        one += 1
    elif data == 0:
        zero += 1
    
    elif data > 1:
        pluspq.put(data*-1)
    
    else:
        minuspq.put(data)

sum = 0
while pluspq.qsize() > 1:
    data1 = pluspq.get() * (-1)
    data2 = pluspq.get() * (-1)
    sum += data1 * data2

if pluspq.qsize() == 1:
    sum += pluspq.get() * (-1)

while minuspq.qsize() > 1:
    data1 = minuspq.get()
    data2 = minuspq.get()    
    sum += data1 * data2

if minuspq.qsize() == 1:
    if zero == 0:
        sum += minuspq.get()

sum += one
print(sum)

