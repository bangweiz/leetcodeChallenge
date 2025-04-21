class MinStack {
	private stack: number[] = [];
	private minNums: number[] = [];

	push(val: number): void {
		this.stack.push(val);
		if (this.minNums.length === 0) {
			this.minNums.push(val);
			return;
		}
		const min = this.minNums[this.minNums.length - 1];
		if (min >= val) {
			this.minNums.push(val);
		}
	}

	pop(): void {
		const num = this.stack.pop()!;
		const min = this.minNums[this.minNums.length - 1];
		if (num === min) {
			this.minNums.pop();
		}
	}

	top(): number {
		return this.stack[this.stack.length - 1];
	}

	getMin(): number {
		return this.minNums[this.minNums.length - 1];
	}
}
