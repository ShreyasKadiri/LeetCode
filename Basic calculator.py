class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        n = 0
        ans = 0
        sign = 1
        for ch in s:
            if ch.isdigit():
                n = 10 * n + int(ch)
            elif ch == "+":
                ans += sign * n
                sign = 1
                n = 0
            elif ch == "-":
                ans += sign * n
                sign = -1
                n = 0
            elif ch == "(":
                stack.append(ans)
                stack.append(sign)
                sign = 1
                ans = 0
            elif ch == ")":
                ans += sign * n
                ans *= stack.pop()
                ans += stack.pop()
                n = 0
        return ans + sign * n
                
