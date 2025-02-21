function merge(nums1: number[], m: number, nums2: number[], n: number): void {
	let i1 = m - 1;
	let i2 = n - 1;
	let i = m + n - 1;
	while (i2 >= 0) {
		if (nums1[i1] > nums2[i2]) {
			nums1[i] = nums1[i1];
			i1--;
		} else {
			nums1[i] = nums2[i2];
			i2--;
		}
		i--;
	}
}

export default merge;
