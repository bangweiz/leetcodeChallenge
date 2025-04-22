function calculate(s: string): number {
	const tokens = convertStrToTokens(s);
	const postFixTokens = convertInfixToPostfix(tokens);
	return calPostFixTokens(postFixTokens);
}

function calPostFixTokens(tokens: Array<number | string>): number {
	const stack: number[] = [];
	for (const token of tokens) {
		if (typeof token === "number") {
			stack.push(token);
			continue;
		}
		if (token === "+") {
			if (stack.length === 1) {
				continue;
			}
			const num1 = stack.pop()!;
			const num2 = stack.pop()!;
			stack.push(num1 + num2);
			continue;
		}
		if (stack.length === 1) {
			stack[0] = -stack[0];
			continue;
		}
		const num1 = stack.pop()!;
		const num2 = stack.pop()!;
		stack.push(num2 - num1);
	}
	return stack.pop()!;
}

function convertInfixToPostfix(
	tokens: Array<number | string>,
): Array<number | string> {
	const postFixTokens: Array<number | string> = [];
	const operators: string[] = [];
	for (const token of tokens) {
		if (typeof token === "number") {
			postFixTokens.push(token);
			continue;
		}
		if (token === "(") {
			operators.push(token);
			continue;
		}
		if (token === ")") {
			while (true) {
				const operator = operators.pop()!;
				if (operator === "(") {
					break;
				}
				postFixTokens.push(operator);
			}
			continue;
		}
		while (true) {
			if (operators.length === 0 || operators[operators.length - 1] === "(") {
				operators.push(token);
				break;
			}
			postFixTokens.push(operators.pop()!);
		}
	}
	while (operators.length > 0) {
		postFixTokens.push(operators.pop()!);
	}
	return postFixTokens;
}

function convertStrToTokens(s: string): Array<number | string> {
	const tokens: Array<number | string> = [];
	let num = "";
	for (let i = 0; i < s.length; i++) {
		const code = s.charCodeAt(i);
		if (code === 32) {
			continue;
		}
		if (48 <= code && code <= 57) {
			num += s[i];
			continue;
		}
		if (num !== "") {
			tokens.push(Number.parseInt(num));
			num = "";
		}
		if (
			s[i] === "-" &&
			(tokens.length === 0 || tokens[tokens.length - 1] === "(")
		) {
			tokens.push(0);
		}
		tokens.push(s[i]);
	}
	if (num !== "") {
		tokens.push(Number.parseInt(num));
	}
	return tokens;
}

export default calculate;
