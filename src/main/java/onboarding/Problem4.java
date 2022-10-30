package onboarding;

import java.util.LinkedList;
import java.util.List;

/*
    기능 목록
    1. List를 만들어 알파벳 소문자를 집어넣는다.
    2. List를 만들어 알파벳 대문자를 집어넣는다.
    3. List를 만들어 1, 2번과 반대되게 z~a까지, Z~A까지 넣는다.
    4. 정렬된 알파벳을 key 그것과 역전되는 알파벳을 value로 가지는 HashMap을 만든다.
    5. word 파라미터를 char[]로 만들고 띄어쓰기만 고려하여 해당 key를 찾아 value로 바꿔준다.

 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // small -> a ~ z, big -> A ~ Z
        // reverseSmall -> z ~ a, reverseBig -> Z ~ A
        List<Character> small = cycle('a');
        List<Character> big = cycle('A');
        List<Character> reverseSmall = reverseCycle('z');
        List<Character> reverseBig = reverseCycle('Z');

        return answer;
    }
    // Step 1. 알파벳 a ~ z 순으로 List에 담기
    public static List<Character> cycle(char word){
        List<Character> tmp = new LinkedList<>();

        for(int i = 0; i < 26; i++){
            tmp.add((char) (word + i));
        }
        return tmp;
    }

    // Step 2. 알파벳 z ~ a 순으로 List에 담기
    public static List<Character> reverseCycle(char word){
        List<Character> tmp = new LinkedList<>();

        for(int i = 0; i < 26; i++){
            tmp.add((char) (word - i));
        }
        return tmp;
    }
}
