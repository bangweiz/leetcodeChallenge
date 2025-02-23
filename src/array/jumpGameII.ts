function jump(nums: number[]): number {
	const dp: number[] = new Array(nums.length).fill(0);
	let indexCanReach = 0;
	for (let i = 0; i < nums.length - 1; i++) {
		const nextIndexCanReach = Math.min(i + nums[i], nums.length - 1);
		for (let j = indexCanReach + 1; j <= nextIndexCanReach; j++) {
			dp[j] = dp[i] + 1;
		}
		indexCanReach = Math.max(indexCanReach, nextIndexCanReach);
	}
	return dp[nums.length - 1];
}

export default jump;
