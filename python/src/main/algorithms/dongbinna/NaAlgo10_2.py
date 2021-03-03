from algorithms.AlgorithmPerform import AlgorithmPerform 

class NaAlgo10_2(AlgorithmPerform):
    def perform(self):
        def find_parent(parent, x):
            if parent[x] != x:
                parent[x] = find_parent(parent, parent[x])
            return parent[x]
