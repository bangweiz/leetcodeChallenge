function canCompleteCircuit(gas: number[], cost: number[]): number {
	let gasRemaining = 0;
	let startIndex = 0;
	for (let i = 0; i < gas.length * 2; i++) {
		const currentIndex = i % gas.length;
		if (i >= gas.length && currentIndex === startIndex) {
			return startIndex;
		}
		gasRemaining += gas[currentIndex] - cost[currentIndex];
		if (gasRemaining < 0) {
			startIndex = i + 1;
			if (startIndex >= gas.length) {
				break;
			}
			gasRemaining = 0;
		}
	}
	return -1;
}

export default canCompleteCircuit;
