'''
 문제 - 동전 0
 동전은 총 N종류, 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램
'''

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