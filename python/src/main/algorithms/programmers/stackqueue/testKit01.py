'''
 문제 - 다리를 지나는 트럭
 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.

 입력 - bridge_length(다리 길이), weight(무게), truck_weight(트럭 무게)
'''
from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge_time = deque([0] * bridge_length)
    time = 0
    num = 0

    while bridge_time :
        time += 1
        temp = bridge_time.popleft()

        if temp != 0:
            num -= temp

        if truck_weights :
            if num + truck_weights[0] <= weight:
                w = truck_weights.pop(0)
                bridge_time.append(w)
                num += w
            else:
                bridge_time.append(0)

    return time
