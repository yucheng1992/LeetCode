package main

import "fmt"

func twoSum(nums []int, target int) []int {
	hash := map[int]int{}
	idx := make([]int, 2)
	for i, val := range nums {
		if j, ok := hash[target - val]; ok {
			idx[0] = j
			idx[1] = i
			break
		}
		hash[val] = i
	}
	return idx
}

func main() {
	var idx = twoSum([]int{3, 2, 4}, 6)
	fmt.Print(idx[0], idx[1])
}
