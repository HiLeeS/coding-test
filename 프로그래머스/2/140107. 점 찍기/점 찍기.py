def solution(k, d):
    answer = 0
    
    for y in range(0, d+1, k):
        x = ((d)**2 - (y)**2)**0.5
        answer += int(int(x) / k) + 1
    
    
    return answer