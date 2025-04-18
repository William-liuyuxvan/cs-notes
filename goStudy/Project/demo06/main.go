package main

import "fmt"

func deferFunc() int {
	fmt.Println("deferFunc")
	return 0
}

func returnFunc() int {
	fmt.Println("returnFunc")
	return 5
}

func returnAndDefer() int {
	defer deferFunc()
	return returnFunc()
}

var a int = 10

func main() {
	returnAndDefer()
}