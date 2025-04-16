function isHappy(n: number): boolean {
	const map = new Set<number>([n]);
	let num = n;
	while (num !== 1) {
		let sum = 0;
		while (num !== 0) {
			sum += (num % 10) ** 2;
			num = Math.floor(num / 10);
		}
		if (map.has(sum)) {
			return false;
		}
		map.add(sum);
		num = sum;
	}
	return true;
}

export default isHappy;
