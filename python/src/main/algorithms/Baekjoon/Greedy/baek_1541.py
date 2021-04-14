'''
 문제 - 잃어버린 괄호
 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램
'''

def solution(self) :
    a = input().split('-')
    num = []

    for i in a :
        s = i.split('+')
        sum = 0
        for j in s :
            sum += int(j)

        num.append(sum)

    result = num[0] 
    for i in range(1, len(num)) :
        result -= num[i]

    print(result)
        