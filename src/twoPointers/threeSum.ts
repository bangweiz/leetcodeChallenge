function threeSum(nums: number[]): number[][] {
	nums.sort((a, b) => a - b);

	const res = new Map<string, number[]>();
	for (let i = 0; i < nums.length - 2; i++) {
		const target = -nums[i];
		let left = i + 1;
		let right = nums.length - 1;
		while (left < right) {
			const sum = nums[left] + nums[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				res.set(`${nums[i]},${nums[left]},${nums[right]}`, [
					nums[i],
					nums[left],
					nums[right],
				]);
				right--;
				left++;
			}
		}
	}
	return Array.from(res.values());
}

export default threeSum;
