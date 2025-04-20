function isValid(s: string): boolean {
	const stack: string[] = [];
	for (const character of s) {
		if (character !== ")" && character !== "]" && character !== "}") {
			stack.push(character);
			continue;
		}
		if (stack.length === 0) {
			return false;
		}
		const prevCharacter = stack.pop();
		switch (character) {
			case ")":
				if (prevCharacter !== "(") {
					return false;
				}
				break;
			case "]":
				if (prevCharacter !== "[") {
					return false;
				}
				break;
			case "}":
				if (prevCharacter !== "{") {
					return false;
				}
				break;
			default:
				break;
		}
	}
	return stack.length === 0;
}

export default isValid;
