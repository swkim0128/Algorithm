    def solution(self):
        # n, k
        n, k = map(int, input().split())

        count = 0

        while True:
            target = (n // k) * k
            count += (n - target)
            n = target
            
            # N이 K보다 작을 때(더 이상 나눌 수 없을 때) 반복문 탈출
            if n < k:
                break
            n //= k
        
        print(count)