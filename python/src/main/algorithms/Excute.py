# from algorithms.dongbinna.greedy03 import solution as sol
# from algorithms.Baekjoon import solution as sol
from algorithms.programmers.greedy.testKit03 import solution as sol
import random


def excute():

    for _ in range(10):
        number = str(random.randrange(1, 1000000))
        k = random.randrange(1, len(number))

        result = sol(number, k)

        print(number, k, result)
