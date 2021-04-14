'''
 문제 - 전화번호 목록
 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
'''

def solution(phone_book):
    phone_book = sorted(phone_book)
    answer = True
    
    for p1, p2 in zip(phone_book, phone_book[1:]) :
        if p2.startswith(p1) :
            answer = False
            break
        answer = True
            
    return answer 
        
def solution02(phone_book):
    result = True
    hash_map = {}

    for phone_number in phone_book:
        hash_map[phone_number] = 1

    for phone_number in phone_book:
        temp = ""

        for phone_num in phone_number:
            temp += phone_num
            print(temp, phone_number)
            if temp in hash_map and temp != phone_number:
                result = False
    
    return result