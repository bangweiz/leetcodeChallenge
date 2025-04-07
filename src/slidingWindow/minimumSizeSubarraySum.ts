function minSubArrayLen(target: number, nums: number[]): number {
	let count = Number.POSITIVE_INFINITY;
	let sum = nums[0];
	let left = 0;
	let right = 0;
	while (right < nums.length) {
		if (sum >= target) {
			count = Math.min(count, right - left + 1);
			if (left === right) {
				right++;
				sum += nums[right];
			}
			sum -= nums[left];
			left++;
		} else {
			right++;
			sum += nums[right];
		}
	}
	return count === Number.POSITIVE_INFINITY ? 0 : count;
}

export default minSubArrayLen;
