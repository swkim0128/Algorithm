from algorithms.AlgorithmPerform import AlgorithmPerform

class baek_1931(AlgorithmPerform) :
    def perform(self) :
        n = int(input())
        I = []

        for i in range(n) :
            start, end = map(int, input().split())
            I.append((start, end))