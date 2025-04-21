function evalRPN(tokens: string[]): number {
	const nums: number[] = [];
	for (const token of tokens) {
		switch (token) {
			case "+":
				nums.push(nums.pop()! + nums.pop()!);
				break;
			case "-":
				nums.push(-nums.pop()! + nums.pop()!);
				break;
			case "*":
				nums.push(nums.pop()! * nums.pop()!);
				break;
			case "/": {
				const num1 = nums.pop()!;
				const num2 = nums.pop()!;
				const isNegative = num1 * num2 < 0;
				const res = Math.floor(Math.abs(num2) / Math.abs(num1));
				nums.push(isNegative ? -res : res);
				break;
			}
			default:
				nums.push(Number.parseInt(token));
				break;
		}
	}
	return nums.pop()!;
}

export default evalRPN;
