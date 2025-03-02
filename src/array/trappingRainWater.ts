function trap(height: number[]): number {
	return twoPointer(height);
}

function twoPointer(height: number[]): number {
	let leftPointer = 0;
	let rightPointer = height.length - 1;
	let leftMaxHeight = 0;
	let rightMaxHeight = 0;
	let water = 0;
	while (leftPointer <= rightPointer) {
		rightMaxHeight = Math.max(rightMaxHeight, height[rightPointer]);
		leftMaxHeight = Math.max(leftMaxHeight, height[leftPointer]);
		if (height[leftPointer] < height[rightPointer]) {
			if (height[leftPointer] < Math.min(leftMaxHeight, rightMaxHeight)) {
				water += Math.min(leftMaxHeight, rightMaxHeight) - height[leftPointer];
			}
			leftPointer++;
		} else {
			if (height[rightPointer] < Math.min(leftMaxHeight, rightMaxHeight)) {
				water += Math.min(leftMaxHeight, rightMaxHeight) - height[rightPointer];
			}
			rightPointer--;
		}
	}

	return water;
}

export default trap;
