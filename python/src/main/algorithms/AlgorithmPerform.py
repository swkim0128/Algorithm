from abc import *

class AlgorithmPerform(metaclass=ABCMeta):
    @abstractmethod
    def perform(self):
        pass

