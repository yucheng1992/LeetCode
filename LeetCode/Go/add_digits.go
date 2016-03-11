package main

import "fmt"

func addDigits(num int) int {
	count := 0
	for num > 0 {
		count += num % 10
		num = num / 10
	}
	if count >= 10 {
		return addDigits(count)
	} else {
		return count
	}
}

func main() {
	fmt.Print(addDigits(38))
}