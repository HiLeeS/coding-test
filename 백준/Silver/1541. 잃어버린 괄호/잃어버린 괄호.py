# 코드를 작성해주세요
import sys
input = sys.stdin.readline

line = input()

sum = 0
num = ''
minus = False
for i in line:
    if i == '+':
        if minus == True:
            sum += int(num) * (-1)
        else: 
            sum += int(num)

        num = ''
        continue
        
    elif i == '-':
        if minus == True:
            sum += int(num) * (-1)
            
        else:
            sum += int(num)
        minus = True
        num = ''
        continue
        
    num += i

if minus:
    sum += int(num)*(-1)
else:
    sum += int(num)

print(sum)