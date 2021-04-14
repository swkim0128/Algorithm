def solution(self) :
    a = input().split('-')
    num = []

    for i in a :
        s = i.split('+')
        sum = 0
        for j in s :
            sum += int(j)

        num.append(sum)

    result = num[0] 
    for i in range(1, len(num)) :
        result -= num[i]

    print(result)
        