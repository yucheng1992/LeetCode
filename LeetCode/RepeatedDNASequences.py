class Solution:
    # @param {string} s
    # @return {string[]}
    def findRepeatedDnaSequences(self, s):
        hash={}
        for i in range(len(s) - 9):
            key=s[i:i+10];
            if key not in hash:
                hash[key] = 1;
            else:
                hash[key] += 1;
        return [i for i in hash.keys() if hash[i] > 1]
