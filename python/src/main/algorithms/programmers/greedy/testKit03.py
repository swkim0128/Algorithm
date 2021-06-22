"""
 문제 - 큰 수 만들기
 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
 number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성 
"""


def solution(number, k):
    # k 자리수 만큼 범위를 지정,
    # 그 중 가장 작은 수 제거,
    # k 횟수만큼 위 행위를 반복, 결과값 출력
    answer = list(number)
    for i in range(k):
        # 자리수를 하였을때
        answer.remove(min(answer[0:k]))

    answer = "".join(answer)
    return answer
