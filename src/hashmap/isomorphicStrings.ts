function isIsomorphic(s: string, t: string): boolean {
	const mapper1: number[] = new Array(256).fill(0);
	const mapper2: number[] = new Array(256).fill(0);
	for (let i = 0; i < s.length; i++) {
		const codeS = s.charCodeAt(i);
		const codeT = t.charCodeAt(i);
		if (mapper1[codeS] === 0) {
			mapper1[codeS] = codeT;
		} else {
			if (mapper1[codeS] !== codeT) {
				return false;
			}
		}
		if (mapper2[codeT] === 0) {
			mapper2[codeT] = codeS;
		} else {
			if (mapper2[codeT] !== codeS) {
				return false;
			}
		}
	}
	return true;
}

export default isIsomorphic;
