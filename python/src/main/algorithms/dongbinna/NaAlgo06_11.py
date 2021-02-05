from algorithms.AlgorithmPerform import AlgorithmPerform 

class NaAlgo06_11(AlgorithmPerform):
    def perform(self):
        n = int(input())

        array = []
        
        # N명의 학생 정보를 입력받아 리스트에 저장
        for i in range(n):
            inputData = input().split()
            # 이름은 문자열 그대로, 점수는 정수형으로 변환하여 저장
            array.append((inputData[0], int(inputData[1])))

        # 키(Key)를 이용하여, 점수를 기준으로 정렬
        array = sorted(array, key=lambda student: student[1])

        for student in array:
            print(student[0], end=' ')