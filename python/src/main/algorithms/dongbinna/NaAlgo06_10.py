from algorithms.AlgorithmPerform import AlgorithmPerform 

class NaAlgo06_10(AlgorithmPerform):
    def perform(self):
        n = int(input())

        array = []

        for i in range(n):
            array.append(int(input()))

        array = sorted(array, reverse=True)

        for i in array:
            print(i, end = ' ')