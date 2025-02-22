function removeDuplicates(nums: number[]): number {
	let i1 = 0;
	let i2 = 0;
	while (i1 < nums.length) {
		if (nums[i1] !== nums[i2]) {
			i2++;
			nums[i2] = nums[i1];
		}
		i1++;
	}
	return i2 + 1;
}

export default removeDuplicates;
