class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, List<List<String>>> layer = new HashMap<>();
        List<List<String>> begin = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        begin.add(list);
        layer.put(beginWord, begin);

        while (!layer.isEmpty()) {
            Map<String, List<List<String>>> newLayer = new HashMap<>();
            for (String word : layer.keySet()) {
                if (word.equals(endWord)) {
                    return layer.get(word);
                }
                for (int i = 0; i < word.length(); i++) {
                    for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                        String newWord = word.substring(0, i) + String.valueOf(c) + word.substring(i+1);
                        if (wordSet.contains(newWord)) {
                            if (!newLayer.containsKey(newWord)) {
                                newLayer.put(newWord, new ArrayList<>());
                            }
                            List<List<String>> lists = newLayer.get(newWord);
                            List<List<String>> a = layer.get(word);
                            for (List<String> subList : a) {
                                lists.add(new ArrayList<>(subList));
                                lists.get(lists.size() - 1).add(newWord);
                            }
                        }
                    }
                }
            }
            layer = newLayer;
            wordSet.removeAll(newLayer.keySet());
        }
        return new ArrayList<>();

    }
}
