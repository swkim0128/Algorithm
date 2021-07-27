'''
 문제 - 주식가격
 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
'''

def solution(prices):
    # 이전 가격과의 차를 이용.
    # 증가값이 음수면 떨어짐, 증가값이 양수면 떨어지지 않는 기간.
    # 증가값 기간동안의 주식가격 배열을 새로운 배열에 스택.
    # 증가값이 음수로 바뀔 때 새로운 배열의 값들을 pop하고, 차례로 시간을 입력.

    increaseList = []
    answer = [] * len(prices)
    time = 0
    frontPrice = 0

    for i in range(len(prices)):
        time += 1
        slope = prices[i] - frontPrice

        if slope >= 0:
            increaseList.append(i)
        else:
            while increaseList:
                answer[increaseList.pop(0)] = time
                time -= 1
