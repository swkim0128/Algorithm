'''
 문제 - 모험가 N명, 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있도록 규정. 최대 몇 개의 그룹으로 만들 수 있는지?
 입력 - N(모험가), X(공포도)
'''

def solution(n, fear):
    fearCount = [0] * (n + 1)
    result = 0

    for f in fear:
        fearCount[f] += 1
    
    dregs = 0
    for i in range(1, n + 1):
        if fearCount[i] == 0:
            continue

        result += fearCount[i] // i
        leftover = fearCount[i] % i

        if dregs + leftover >= i:
            result += (dregs + leftover) / i
            dregs = (dregs + leftover) % i
        else:
            dregs += leftover

    return result