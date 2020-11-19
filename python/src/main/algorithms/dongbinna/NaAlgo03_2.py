from algorithms.AlgorithmPerform import AlgorithmPerform

class NaAlgo03_2(AlgorithmPerform):
    def perform(self):
        # n, k
        n, k = map(int, input().split())

        count = 0

        while True:
            # (N == K로 나누어 떨어지는 수)가 될 때까지 1씩 빼기
            target = (n // k) * k
            count += (n - target)
            n = target
            
            # N이 K보다 작을 때(더 이상 나눌 수 없을 때) 반복문 탈출
            if n < k:
                break

            count += 1
            n //= k
        
        # 마지막으로 남은 수에 대하여 1씩 빼기
        count += (n - 1)
        print(count)

