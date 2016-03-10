package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	hash := map[string]int{}
	prev, maxVal := 0, 0
	for i := 0; i < len(s); i++ {
		if val, ok := hash[string(s[i])]; ok && val == 1 {
			if i - prev > maxVal {
				maxVal = i - prev
			}
			for prev < i {
				if string(s[prev]) == string(s[i]) {
					prev += 1
					break
				} else {
					hash[string(s[prev])] = 0
					prev += 1
				}

			}
		} else {
			if i - prev + 1 > maxVal {
				maxVal = i - prev + 1
			}
			hash[string(s[i])] = 1
		}
	}
	return maxVal
}

func main() {
	fmt.Print(lengthOfLongestSubstring("tmmzuxt"))
}