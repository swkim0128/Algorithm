'''
 문제 - ATM
 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램
'''

def solution(self) :
    n = int(input())
    p = list(map(int, input().split()))

    p.sort()

    sum = [0 for _ in range(n)]
    sum[0] = p[0]
    result = sum[0]

    for i in range(1, n) :
        sum[i] = sum[i - 1] + p[i]
        result += sum[i]

    print(result)