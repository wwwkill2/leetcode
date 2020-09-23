class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}
        for str in strs:
            key = ''.join(sorted(str))
            if key not in d:
                d[key] = []
            d[key].append(str)
        return list(d.values())
