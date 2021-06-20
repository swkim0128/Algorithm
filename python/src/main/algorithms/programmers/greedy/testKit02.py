"""
 문제 - 조이스틱
 조이스틱으로 알파벳 이름을 완성.
 ▲ - 다음 알파벳
 ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 ▶ - 커서를 오른쪽으로 이동
 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return
"""


def solution(name):
    moveCount = 0
    length = len(name)
    minMove = length - 1

    # a b c d e f g h i j k l m | n o p q r s t u v w x y z
    # 알파벳 a 에서 알바벳 n 을 기준으로 삼아 12, 이전 12, n : 다음, 이전 둘 다 13
    # --> 알파벳 n 보다 작으면 다음 알파벳 이동 횟수,
    # 알파벳 n 보다 크면 이전 알파벳 이동 횟수로 계산
    for n in name:
        if n < "N":
            moveCount += ord(n) - ord("A")
        elif n > "N":
            moveCount += 26 - (ord(n) - ord("A"))
        else:
            moveCount += 13

    for i in range(length):
        nextIndex = i + 1
        while nextIndex < length and name[nextIndex] == "A":
            nextIndex += 1

        minMove = min(minMove, (i * 2) + length - nextIndex)

    moveCount += minMove

    return moveCount
