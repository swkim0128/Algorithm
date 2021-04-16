'''
 문제 - 베스트앨범
 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수
'''

def solution(geners, plays):
    count = {}
    order = {} 
    for i in range(len(geners)):
        if geners[i] in count:
            count[geners[i]] += plays[i]
            order[geners[i]].append((i, plays[i]))
        else:
            count[geners[i]] = plays[i]
            order[geners[i]] = []
            order[geners[i]].append((i, plays[i]))

    count_reverse = sorted(count.items(), reverse=True, key=lambda item: item[1])

    result = []
    for g, c in count_reverse:
        temp_list = sorted(order[g], reverse=True, key=lambda x : x[1])
        if len(temp_list) < 2:
            for i in range(len(temp_list)):
                result.append(temp_list[i][0])
        else:
            result.append(temp_list[0][0])
            result.append(temp_list[1][0])

    return result