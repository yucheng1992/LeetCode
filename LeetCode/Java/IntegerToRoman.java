public class IntegerToRoman {
    
    public String intToRoman(int num) {
        String res = "";
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num != 0; i++) {
            while (num >= value[i]) {
                num -= value[i];
                res += str[i];
            }
        }
        return res;
    }
    
    public String intToRoman2(int num) {
        StringBuffer res = new StringBuffer();
        int thu = num / 1000;
        for (int i=0; i<thu; i++) {
            res.append('M');
        }
        num = num - 1000 * thu;
        if (num >= 900) {
            res.append("CM");
            num = num - 900;
        } else {
            int fiveHud = num / 500;
            for (int i=0; i<fiveHud; i++) {
                res.append('D');
            }
            num = num - 500 * fiveHud;
        }
        if (num >= 400) {
            res.append("CD");
            num = num - 400;
        } else {
            int hud = num / 100;
            for (int i=0; i<hud; i++) {
                res.append('C');
            }
            num = num - 100 * hud;
        }
        if (num >= 90) {
            res.append("XC");
            num = num - 90;
        } else {
            int fifty = num / 50;
            for (int i=0; i<fifty; i++) {
                res.append('L');
            }
            num = num - 50 * fifty;
        }
        if (num >= 40) {
            res.append("XL");
            num = num - 40;
        } else {
            int ten = num / 10;
            for (int i=0; i<ten; i++) {
                res.append('X');
            }
            num = num - 10 * ten;
        }
        if (num >= 9) {
            res.append("IX");
            num = num - 9;
        } else {
            int five = num / 5;
            for (int i=0; i<five; i++) {
                res.append('V');
            }
            num = num - 5 * five;
        }
        if (num >= 4) {
            res.append("IV");
            num = num - 4;
        } else {
            for (int i=0; i<num; i++) {
                res.append('I');
            }
        }
        return res.toString();
    }
}
