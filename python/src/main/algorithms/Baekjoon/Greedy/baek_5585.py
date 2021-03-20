from algorithms.AlgorithmPerform import AlgorithmPerform

class baek_5585(AlgorithmPerform) :
    def perform(self) :
        n = int(input())
        change = 1000 - n

        coin = [500, 100, 50, 10, 5, 1]

        ans = 0
        i = 0
        while change > 0 :
            if change >= coin[i] :
                ans += 1
                change -= coin[i]

            else :
                i += 1

        print(ans)