class Solution:
    def replaceDigits(self, text:str) -> str:
        nums = [str(ord(x) - 96) for x in text.lower() if x >= 'a' and x <= 'z']
        return " ".join(nums)
        
