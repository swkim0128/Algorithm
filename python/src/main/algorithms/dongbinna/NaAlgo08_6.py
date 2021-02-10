from algorithms.AlgorithmPerform import AlgorithmPerform 

class NaAlgo08_6(AlgorithmPerform):
    def perform(self):
        n = int(input())
        k = list(map(int, input().split()))

        d = [0] * 101
        d[0] = k[0]
        d[1] = max(k[0], k[1])

        for i in range(2, n):
            d[i] = max(d[i - 1], k[i] + d[i - 2])

        print(d[n - 1])