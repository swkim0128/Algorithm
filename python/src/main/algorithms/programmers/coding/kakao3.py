def solution(n, k, cmd):
    # 행의 개수 n, 처음 선택된 행의 위치 k, 수행한 명령어 문자열 cmd
    # 모든 명령어를 수행 후 처음 표와 비교하여 삭제되지 않은 행 o, 된 행 x 표시 return
    # 명령어
    # U x : 현재 선택된 행에서 x 칸 위에 있는 행 선택
    # D x : 현재 선택된 행에서 x 칸 아래에 있는 행 선택
    # C : 선택된 행 삭제 후 아래 행 선택
    # Z : 가장 최근에 삭제된 행을 원래대로 복구, 현재 선택되니 행은 바뀌지 않음.
    array = ["O"] * n
    current_state = [i for i in range(n)]
    order_num = 0

    stack = []

    for c in cmd:
        cmds = list(c.split())
        order = cmds[0]

        if order == 'D':
            k += int(cmds[1])
            if index_exists(current_state, k):
                order_num = current_state[k]
            else:
                k = n - 1
        elif order == 'U':
            k -= int(cmds[1])
            if k < 0:
                k = 0
        elif order == 'C':
            order_num = current_state[k]
            array[order_num] = 'X'
            stack.append(order_num)

            if k == n - 1:
                k = n - 2
            else:
                k += 1
        elif order == 'Z':
            order_num = stack.pop()
            array[order_num] = 'O'

    answer = ""
    for a in array:
        answer += a
    return answer
