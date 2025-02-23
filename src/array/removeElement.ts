function removeElement(nums: number[], val: number): number {
	let i1 = 0;
	let i2 = 0;
	let count = 0;
	while (i1 < nums.length) {
		if (nums[i1] !== val) {
			[nums[i1], nums[i2]] = [nums[i2], nums[i1]];
			i2++;
			count++;
		}
		i1++;
	}
	return count;
}

export default removeElement;
