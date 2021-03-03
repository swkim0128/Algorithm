from algorithms.AlgorithmPerform import AlgorithmPerform

class baek_11399(AlgorithmPerform) :
    def perform(self) :
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