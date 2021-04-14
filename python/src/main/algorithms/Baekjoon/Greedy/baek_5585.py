'''
 문제 - 거스름돈
 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성
'''

def solution(self) :
    n = int(input())
    change = 1000 - n

    coin = [500, 100, 50, 10, 5, 1]

    ans = 0
    i = 0
    while change > 0 :
        if change >= coin[i] :
            ans += 1
            change -= coin[i]

        else :
            i += 1

    print(ans)