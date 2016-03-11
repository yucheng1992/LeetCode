package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	if (root == nil) {
		return nil
	}
	if (root.Left == nil && root.Right == nil) {
		return root
	}
	node := root.Left
	root.Left = root.Right;
	root.Right = node;
	invertTree(root.Left);
	invertTree(root.Right);
	return root
}

func main() {
	var root = TreeNode{1, nil, &TreeNode{2, &TreeNode{3, nil, nil}, nil}}
	var newRoot = invertTree(&root)
	fmt.Print(newRoot)
}