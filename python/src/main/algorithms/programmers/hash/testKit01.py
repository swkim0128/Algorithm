from algorithms.AlgorithmPerform import AlgorithmPerform

class testKit01(AlgorithmPerform) :
    def perform(self) :
        def solution(participant, completion):
            participant.sort()
            completion.sort()
            
            for par, com in zip(participant, completion) :
                if par != com :
                    return par
                
            return participant[-1]

        def solution02(participant, completion) :
            import collections

            answer = collections.Counter(participant) - collections.Counter(completion)
            return list(answer.keys())[0]