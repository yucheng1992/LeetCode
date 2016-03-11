package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func maximum_depth(root *TreeNode) int {
	if (root == nil) {
		return 0
	}
	return max(maximum_depth(root.Left), maximum_depth(root.Right)) + 1;
}

func max(left int, right int) int {
	if left > right {
		return left
	} else {
		return right
	}
}

func main() {
	var root = TreeNode{1, nil, &TreeNode{2, &TreeNode{3, nil, nil}, nil}}
	fmt.Print(maximum_depth(&root))
}
