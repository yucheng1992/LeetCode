package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	var nodes []int
	helper(root, &nodes)
	return nodes
}

func helper(root *TreeNode, nodes *[]int) {
	if (root == nil) {
		return
	}
	*nodes = append(*nodes, root.Val)
	if (root.Left != nil) {
		helper(root.Left, nodes);
	}
	if (root.Right != nil) {
		helper(root.Right, nodes);
	}
}

func main() {
	var root = TreeNode{1, nil, &TreeNode{2, &TreeNode{3, nil, nil}, nil}}
	var nodes = preorderTraversal(&root)
	fmt.Print(nodes)
}
