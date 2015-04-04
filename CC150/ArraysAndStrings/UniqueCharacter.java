public class UniqueCharacter {
    public boolean isUnique(String s) {
        if (s.length() > 256) {
            return false;
        }
        boolean[] charArray = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charArray[val]) {
                return false;
            }
            charArray[val] = true;
        }
        return true;
    }
}
