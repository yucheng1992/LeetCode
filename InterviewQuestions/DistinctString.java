public class DistinctString {
    public static int numDistinctDP(String s1, String s2){
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                HashMap<Character, Integer> map = new HashMap<Character, Integer>();.
                //transform s2
                for(int i = 0; i < s2.length(); i += 2){
                        char c = s2.charAt(i);
                        sb2.append(c);
                        map.put(c, s2.charAt(i + 1) == '+'? 1: 3);
                }
                s2 = sb2.toString();
                //transform s1
                for(int i = 0; i < s1.length() - 1; i++){
                        char c = s1.charAt(i);
                        if(map.containsKey(c)){
                                int value = map.get(c);
                                if(isValid(s1, i, value, c)){
                                        sb1.append(c);
                                }
                        }
                }
                s1 = sb1.toString();
                int[][] num = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            num[i][0] = 1;.
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                num[i][j] += num[i - 1][j];
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    num[i][j] += num[i - 1][j - 1];
                }
            }
        }
        return num[s1.length()][s2.length()];
        }

}
