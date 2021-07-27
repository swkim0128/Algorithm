"""
 문제 - 기능 개발
  배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
  각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성
"""


def solution(progresses, speeds):
    # 종료 조건 : progresses 들이 모두 100%가 될 때까지
    # n 일차 마다 각 progresses는 작업율을 각 speeds만큼 증가
    # 작업률이 100% 이면 pop, count 증가
    count = 0
    answer = []
    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
            if progresses[i] >= 100:
                progresses[i] = 100

        while progresses:
            if progresses[0] == 100:
                progresses.pop(0)
                speeds.pop(0)
                count += 1
            else:
                break

        if count != 0:
            answer.append(count)
            count = 0

    return answer
