function twoSum(nums: number[], target: number): number[] {
	const map = new Map<number, number>();
	for (let i = 0; i < nums.length; i++) {
		const numNeeded = target - nums[i];
		if (map.has(numNeeded)) {
			return [map.get(numNeeded)!, i];
		}
		map.set(nums[i], i);
	}
	return [];
}

export default twoSum;
