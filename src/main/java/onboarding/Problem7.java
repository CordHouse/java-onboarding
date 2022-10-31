package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    기능 목록
    1. TreeMap 을 통해서 정렬된 key : value 값으로 세팅한다.
    2. 정렬이 총 두번 필요하므로, 1차 이름별 정렬 -> TreeMap, 2차 점수별 정렬 -> sort
    3. map -> value
        -> 본인은 카운트에서 제외
        -> 사용자와 함께 아는 친구가 있다면 점수 10점 추가
        -> 사용자의 타임 라인 방문한 횟수 1점
 */
public class Problem7 {
    // 방문에 따른 점수를 부여할 TreeMap 선언
    static Map<String, Integer> visitorMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // key -> 방문자 이름, value -> 점수
        visitorMap = new TreeMap<>();

        // 맵 초기값 설정
        mapSet(user, friends, visitors);
        return answer;
    }

    // 파라미터
    // -> user : 사용자, friends : 친구 관계, visitors : 방문 타임라인
    public static void mapSet(String user, List<List<String>> friends, List<String> visitors){
        for(int i = 0; i < visitors.size(); i++){
            // TreeMap 안에 있는 Key에 값에 따라 초기값 지정
            if(!visitorMap.containsKey(visitors.get(i))){
                visitorMap.put(visitors.get(i), 0);
            }
            else{
                visitorMap.put(visitors.get(i), visitorMap.get(visitors.get(i))+1);
            }
            // 초기값 지정 후 추천 함수 실행
            suggestion(friends, visitors.get(i), user);
        }
    }

    // 파라미터 -> mapSet 함수와 동일
    public static void suggestion(List<List<String>> friends, String visitor, String user){
        for(int i = 0; i< friends.size(); i++){
            // 본인과의 관계만 있는 경우 제외
            if(friends.get(i).contains(user)){
                continue;
            }
            // 친구 관계 안에 타임 라인 방문자가 포함된 경우 실행
            if(friends.get(i).contains(visitor)){
                for(int j = 0; j < 2; j++){
                    // friend -> i = 0, j = 0 : donut, i = 0, j = 1 : andole
                    String friend = friends.get(i).get(j);
                    // 방문 기록과 이름이 다르고, TreeMap에 저장이 안된 경우
                    if(!friend.equals(visitor) && !visitorMap.containsKey(friend)){
                        visitorMap.put(friend, 10);
                    }
                    // 방문 기록과 이름이 다르고, TreeMap에 저장이 되어 있는 경우
                    else if(!friend.equals(visitor) && visitorMap.containsKey(friend)){
                        visitorMap.put(friend, visitorMap.get(friend) + 10);
                    }
                }
            }
        }
    }
}
