function productExceptSelf(nums: number[]): number[] {
	const prefixProduct: number[] = new Array(nums.length).fill(1);
	for (let i = 0; i < nums.length - 1; i++) {
		prefixProduct[i + 1] = prefixProduct[i] * nums[i];
	}

	const res: number[] = new Array(nums.length).fill(
		prefixProduct[nums.length - 1],
	);
	let suffixProduct = 1;
	for (let i = nums.length - 1; i > 0; i--) {
		suffixProduct *= nums[i];
		res[i - 1] = suffixProduct * prefixProduct[i - 1];
	}
	return res;
}

export default productExceptSelf;
