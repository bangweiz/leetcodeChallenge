function summaryRanges(nums: number[]): string[] {
	if (nums.length === 0) {
		return [];
	}
	if (nums.length === 1) {
		return [nums[0].toString()];
	}
	const res: string[] = [];
	let start = 0;
	let end = 1;
	while (true) {
		if (end === nums.length) {
			if (start === end - 1) {
				res.push(nums[start].toString());
			} else {
				res.push(`${nums[start]}->${nums[end - 1]}`);
			}
			break;
		}
		if (nums[end] !== nums[end - 1] + 1) {
			if (start === end - 1) {
				res.push(nums[start].toString());
			} else {
				res.push(`${nums[start]}->${nums[end - 1]}`);
			}
			start = end;
			end++;
		} else {
			end++;
		}
	}
	return res;
}

export default summaryRanges;
