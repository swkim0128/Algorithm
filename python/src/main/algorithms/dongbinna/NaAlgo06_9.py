from algorithms.AlgorithmPerform import AlgorithmPerform 

class NaAlgo06_9(AlgorithmPerform):
    def perform(self):
        array = [('바나나', 2), ('사과', 5), ('당근', 3)]

        def setting(data):
            return data[1]

        result = sorted(array, key=setting)
        print(result)