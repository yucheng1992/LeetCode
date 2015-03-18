public class RomanToInteger {

    //much faster!    
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                res += res > 3? -1: 1;
            } else if (s.charAt(i) == 'V') {
                res += 5;
            } else if (s.charAt(i) == 'X') {
                res += res > 30? -10: 10;
            } else if (s.charAt(i) == 'L') {
                res += 50;
            } else if (s.charAt(i) == 'C') {
                res += res > 300? -100: 100;
            } else if (s.charAt(i) == 'D') {
                res += 500;
            } else {
                res += 1000;
            }
        }
        return res;
    }
    
    public int romanToInt2(String s) {
        int res = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char cur = s.charAt(i);
            switch(cur) {
                case 'I':
                    res += res>=5 ? -1: 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50? -1: 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500? -1: 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
