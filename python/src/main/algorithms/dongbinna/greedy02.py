'''
 문제 - 곱하기 혹은 더하기
  숫자로 이루어진 문자열 S, 숫자 사이에 'x' 혹은 '+' 연산자를 넣어 가장 큰수를 구하는 프로그램.
'''

def solution(str):

    # 다음 연산이 + : False, * : True
    nextOper = False

    result = 0
    for s in str:
        if int(s) <= 1 or result <= 1:
            nextOper = False
        else:
            nextOper = True

        if nextOper:
            result *= int(s)
        else:
            result += int(s)
        

    return result