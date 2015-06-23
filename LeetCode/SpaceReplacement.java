public class SpaceReplacement {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int spaceNum = 0;
        int trueLength = length;
        for (int i = 0; i < trueLength; i++) {
            if (string[i] == ' ') {
                spaceNum += 1;
                trueLength += 2;
                for (int j = length - 1 + 2 * spaceNum; j > i + 2; j--) {
                    string[j] = string[j-2];
                }
                string[i] = '%';
                string[i+1] = '2';
                string[i+2] = '0';
                i += 2;
            }
        }
        return trueLength;
    }
}
