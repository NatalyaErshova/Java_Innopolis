package exercise;
/*даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными,
и false, если нет.
Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву
во втором слове, при этом повторяющиеся буквы одного слова меняются на одну и ту же букву
с сохранением порядка следования.
Например, add - egg изоморфны
Буква может не меняться, а остаться такой же (напр., note - code)
Пример: foo bar false, paper title true
 */

import java.util.HashMap;
import java.util.Map;

class ex09 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(mapST.containsKey(charS)) {
                if(!mapST.get(charS).equals(charT)) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

            if(mapTS.containsKey(charT)) {
                if(!mapTS.get(charT).equals(charS)) {
                    return false;
                }

            } else {
                mapTS.put(charT, charS);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "foo"; String t1 = "bar";
        System.out.printf("'%s' и '%s' изоморфны? %b%n", s1, t1, isIsomorphic(s1,t1));
        String s2 = "add"; String t2 = "egg";
        System.out.printf("'%s' и '%s' изоморфны? %b%n", s2, t2, isIsomorphic(s2,t2));
    }
}
