public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls += 1;
            } else {
                if (count.containsKey(secret.charAt(i))) {
                    count.put(secret.charAt(i), count.get(secret.charAt(i)) + 1);
                } else {
                    count.put(secret.charAt(i), 1);
                }
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i) && count.containsKey(guess.charAt(i))) {
                if (count.get(guess.charAt(i)) > 0) {
                    cows += 1;
                }
                count.put(guess.charAt(i), count.get(guess.charAt(i)) - 1);
            }
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }
}
