"""
 문제 - 체육복
 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 체육수업을 들을 수 있는 학생의 최댓값을 return
"""


def solution(n, lost, reserve):
    lostCount = len(lost)

    for _ in range(lostCount):
        l = lost.pop(0)
        if l in reserve:
            reserve.pop(reserve.index(l))
            lostCount -= 1
        else:
            lost.append(l)

    for l in lost:
        for r in reserve:
            if l == r - 1:
                reserve.pop(reserve.index(r))
                lostCount -= 1
                break
            elif l == r + 1:
                reserve.pop(reserve.index(r))
                lostCount -= 1
                break

    answer = n - lostCount
    return answer
