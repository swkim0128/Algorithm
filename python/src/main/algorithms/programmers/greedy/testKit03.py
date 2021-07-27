"""
 문제 - 큰 수 만들기
 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
 number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성 
"""


def solution(number, k):
    # k 자리수 만큼 범위를 지정,
    # len(number) - k : 출력할 자리 수 개수
    # 출력할 자리 수 개수의 높은 수 찾기
    # k 횟수만큼 위 행위를 반복, 결과값 출력
    answer = []

    numberLength = len(number)
    answerLength = len(number) - k
    startSearchIndex = 0
    endSearchIndex = numberLength - answerLength + 1
    answerSearchLength = answerLength

    for _ in range(answerLength):
        searchNumber = max(number[startSearchIndex:endSearchIndex])
        answer.append(searchNumber)

        answerSearchLength -= 1
        startSearchIndex = number.find(searchNumber, startSearchIndex) + 1
        endSearchIndex = numberLength - answerSearchLength + 1

    answer = "".join(answer)
    return answer
