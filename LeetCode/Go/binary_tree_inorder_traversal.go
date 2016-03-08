package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	var nodes []int
	helperInorder(root, &nodes)
	return nodes
}

func helperInorder(root *TreeNode, nodes *[]int) {
	if (root == nil) {
		return
	}
	if (root.Left != nil) {
		helperInorder(root.Left, nodes);
	}
	*nodes = append(*nodes, root.Val)
	if (root.Right != nil) {
		helperInorder(root.Right, nodes);
	}
}

func main() {
	var root = TreeNode{1, nil, &TreeNode{2, &TreeNode{3, nil, nil}, nil}}
	var nodes = inorderTraversal(&root)
	fmt.Print(nodes)
}
