class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = new char[26];
            for (char c : str.toCharArray()) {
                ca[c-'a']++;
            }
            String sortedStr = String.valueOf(ca);
            if (!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>();
                map.put(sortedStr, list);
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
