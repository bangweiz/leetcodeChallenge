function rotate(nums: number[], k: number): void {
	swap(0, k);

	function swap(start: number, k: number) {
		const length = nums.length - start;
		const rotateLength = k % length;
		if (rotateLength === 0) {
			return;
		}

		for (let i = 0; i < rotateLength; i++) {
			const [v1, v2] = [nums[start + i], nums[nums.length - rotateLength + i]];
			nums[start + i] = v2;
			nums[nums.length - rotateLength + i] = v1;
		}
		swap(start + rotateLength, rotateLength);
	}
}

export default rotate;
