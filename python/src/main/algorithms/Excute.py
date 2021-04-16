# from algorithms.dongbinna import solution as sol
# from algorithms.Baekjoon import solution as sol
from algorithms.programmers.hash.testKit04 import solution as sol

def excute():
    generes = ["classic", "pop", "classic", "classic", "pop"]
    plays = [500, 600, 150, 800, 2500]

    result = sol(generes, plays)

    print(result)