'''
 문제 - 회의실 배정
 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
'''

def solution(self) :
    n = int(input())
    time = sorted([tuple(map(int, input().split())) for _ in range(n)], key=lambda x:(x[1], x[0]))

    ans = end = 0
    for s, e in time :
        if s >= end :
            ans += 1
            end = e

    print(ans)