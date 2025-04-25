import sys
input = sys.stdin.readline

n = int(input())
num = [0]*n

for i in range(n):
    num[i] = int(input())

stack = []
result = []
count = 0

i = 1
while count != len(num):
    
    if stack and stack[-1] == num[count]:
        stack.pop()
        result.append("-")
        count += 1
    else:
        stack.append(i)
        i += 1
        result.append("+")
    
    if i > n and stack and stack[-1] != num[count]:
        break


if count == len(num):
    for i in result:
        print(i)

else:
    print("NO")
