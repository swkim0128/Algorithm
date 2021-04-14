def solution(self) :
    n, k = map(int, input().split())
    a = []

    for i in range(n) :
        a.append(int(input()))

    start = 0
    for i in range(n - 1, -1, -1) :
        if a[i] <= k :
            start = i
            break

    count = 0
    for i in range(start, -1, -1) :
        count += k // a[i]
        k %= a[i]

    print(count)