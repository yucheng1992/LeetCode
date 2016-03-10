package main

import (
	"fmt"
	"bytes"
)

func zigzagConversion(s string, numRows int) string {
	var buffer bytes.Buffer
	set := len(s) / (2 * numRows - 2)
	if len(s) % (2 * numRows - 2) != 0 {
		set += 1
	}
	for i := 0; i < numRows; i++ {
		for j := 0; j < set; j++ {
			if (i == 0 || i == numRows - 1) {
				if (j * (2 * numRows - 2) + i < len(s)) {
					buffer.WriteByte(s[j * (2 * numRows - 2) + i]);
				}
			} else {
				if (j * (2 * numRows - 2) + i < len(s)) {
					buffer.WriteByte(s[j * (2 * numRows - 2) + i]);
				}
				if ((j + 1) * (2 * numRows - 2) - i < len(s)) {
					buffer.WriteByte(s[(j + 1) * (2 * numRows - 2) - i]);
				}
			}
		}
	}
	return buffer.String()
}

func main() {
	fmt.Print(zigzagConversion("PAYPALISHIRING", 3))
}