function rotate(nums: number[], k: number): void {
	swap(0, k);

	function swap(start: number, k: number) {
		const length = nums.length - start;
		const rotateLength = k % length;
		if (rotateLength === 0) {
			return;
		}

		for (let i = 0; i < rotateLength; i++) {
			[nums[nums.length - rotateLength + i], nums[start + i]] = [
				nums[start + i],
				nums[nums.length - rotateLength + i],
			];
		}
		swap(start + rotateLength, rotateLength);
	}
}

export default rotate;
