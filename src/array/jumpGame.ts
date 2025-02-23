function canJump(nums: number[]): boolean {
	let indexCanReach = 0;
	for (let i = 0; i < nums.length; i++) {
		if (i > indexCanReach) {
			return false;
		}
		indexCanReach = Math.max(indexCanReach, nums[i] + i);
	}
	return true;
}

export default canJump;
