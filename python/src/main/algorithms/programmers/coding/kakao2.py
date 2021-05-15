# 어느 한 자리 P(x, y)에 대해서 맨허튼 거리 2이하
# 즉 P1, P2 사이에 가로, 세로로 빈자리가 2개 이상, 대각선으로 자리가 비어 있거나 X이여야 함.


def findKeepDistance(array):
    # 동, 남, 서, 북
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    examinee = []
    visited = [[False for _ in range(5)] for _ in range(5)]
    result = True

    for i in range(5):
        for j in range(5):
            if array[i][j] == "P":
                examinee.append((i, j))

    while examinee:
        y, x = examinee.pop(0)

        stack = []
        stack.append((y, x))
        visited[y][x] = True

        while stack:
            now_y, now_x = stack.pop()

            for i, j in zip(dy, dx):
                ny = now_y + i
                nx = now_x + j

                if ny < 0 or nx < 0 or 5 <= ny or 5 <= nx:
                    continue
                if abs(y - ny) + abs(x - nx) > 2:
                    continue
                if not visited[ny][nx]:
                    if array[ny][nx] == "X":
                        result = True
                        visited[ny][nx] = True
                    elif array[ny][nx] == "P":
                        return False
                    else:
                        stack.append((ny, nx))
                        visited[ny][nx] = True

    return result


def solution(places):
    answer = []
    waiting_room = []

    for row in places:
        for column in row:
            waiting_room.append(list(column))

        if findKeepDistance(waiting_room):
            answer.append(1)
        else:
            answer.append(0)
        waiting_room.clear()

    return answer
