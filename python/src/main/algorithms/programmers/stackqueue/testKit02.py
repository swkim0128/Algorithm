"""
 문제 - 프린터
 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 3. 그렇지 않으면 J를 인쇄합니다.
 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성
"""
from collections import deque


def solution(priorities, location):
    wait_list = deque()
    for i in range(len(priorities)):
        wait_list.append((i, priorities[i]))

    answer = []
    count = 0
    while wait_list:
        index, priority = wait_list.popleft()
        is_print = True

        for i, j in wait_list:
            if priority < j:
                wait_list.append((index, priority))
                is_print = False
                break

        if is_print:
            answer.append((index, priority))
            count += 1

            if index == location:
                break

    return count
    # 대기 목록 (i, j)
    # 대기 목록 중에서 [0] 보다 우선순위가 큰 것이 있다면 인덱스 [0]에 있는 목록은 다시 뒤로 옮김.
