'''
 문제 - 위장
 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수
'''

def solution(clothes):
    clothe = {}

    for c in clothes:
        if c[1] in clothe:
            clothe[c[1]] += 1
        else:
            clothe[c[1]] = 1

    value_list = clothe.values()

    result = 1
    for value in value_list:
        result *= value + 1

    result -= 1

    return result