# 코드를 작성해주세요
import sys
input = sys.stdin.readline

checkList = [0]*4  # A, C, G, T 최소 개수 조건
myList = [0]*4     # 현재 윈도우 내 A, C, G, T 개수
checkSecret = 0           # 조건을 만족하는 알파벳 개수 (0~4 중)

def myadd(c):   #새로 들어온 문자를 처리하는 함수
    global checkSecret, myList, checkList
    if c == 'A':
        myList[0] += 1
        if myList[0] == checkList[0]:
            checkSecret += 1
    elif c == 'C':
        myList[1] += 1
        if myList[1] == checkList[1]:
            checkSecret += 1
    
    elif c == 'G':
        myList[2] += 1
        if myList[2] == checkList[2]:
            checkSecret += 1
    elif c == 'T':
        myList[3] += 1
        if myList[3] == checkList[3]:
            checkSecret += 1
    
def myremove(c):    #제거되는 문자를 처리하는 함수
    global checkSecret, myList, checkList
    if c == 'A':
        if myList[0] == checkList[0]:
            checkSecret -= 1
        myList[0] -= 1
    elif c == 'C':
        if myList[1] == checkList[1]:
            checkSecret -= 1
        myList[1] -= 1
    elif c == 'G':
        if myList[2] == checkList[2]:
            checkSecret -= 1
        myList[2] -= 1
    elif c == 'T':
        if myList[3] == checkList[3]:
            checkSecret -= 1
        myList[3] -= 1


s, p = map(int, input().split())
result = 0
string = input()
checkList = list(map(int, input().split()))

for i in range(4):
    if checkList[i] == 0:
        checkSecret += 1
    
for i in range(p):  #초기 p부분 문자열 처리 부분
    myadd(string[i])

if checkSecret == 4:
    result += 1

for i in range(p, s):
    j = i -p
    myadd(string[i])
    myremove(string[j])
    if checkSecret == 4:
        result += 1


print(result)