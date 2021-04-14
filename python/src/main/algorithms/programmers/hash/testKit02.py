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