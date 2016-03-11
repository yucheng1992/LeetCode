package main

import "fmt"

func singleNumber(nums []int) int {
	n := 0
	for i := range nums {
		n = n ^ i
	}
	return n
}

func main() {
	fmt.Print(singleNumber([]int{1, 2, 3, 4, 5, 1}))
}