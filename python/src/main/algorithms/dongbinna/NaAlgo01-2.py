# n, m, k
n, m, k = map(int, input().split())

# n[m]
data = list(map(int, input().split()))

data.sort()
first = data[n - 1]
second = data[n - 2]

count = int(m / (k + 1)) * k
count += m % (k + 1)

result = 0
result += first * count
result += second * (m - count)

print(result)

