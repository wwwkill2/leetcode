class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (endWord == null || wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> allComboDict = new HashMap<>();
        int n = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < n; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                if (!allComboDict.containsKey(key)) {
                    allComboDict.put(key, new ArrayList<>());
                }
                allComboDict.get(key).add(word);
            }
        }
        Deque<Pair<String, Integer>> qBegin = new LinkedList<>();
        Deque<Pair<String, Integer>> qEnd = new LinkedList<>();
        qBegin.offerLast(new Pair<>(beginWord, 1));
        qEnd.offerLast(new Pair<>(endWord, 1));
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);
        while (!qBegin.isEmpty() && !qEnd.isEmpty()) {
            int res = visitWord(qBegin, visitedBegin, visitedEnd, allComboDict);
            if (res != -1) {
                return res;
            }
            res = visitWord(qEnd, visitedEnd, visitedBegin, allComboDict);
            if (res != -1) {
                return res;
            }
        }
        return 0;
    }

    private int visitWord(Deque<Pair<String, Integer>> q, Map<String, Integer> visited, Map<String, Integer> otherVisited, Map<String, List<String>> allComboDict) {
        Pair<String, Integer> pair = q.pollFirst();
        for (int i = 0; i < pair.getKey().length(); i++) {
            String intermediateWord = pair.getKey().substring(0, i) + "*" + pair.getKey().substring(i + 1, pair.getKey().length());
            if (allComboDict.containsKey(intermediateWord)) {
                for (String word : allComboDict.get(intermediateWord)) {
                    if (otherVisited.containsKey(word)) {
                        return otherVisited.get(word) + pair.getValue();
                    }
                    if (!visited.containsKey(word)) {
                        q.offerLast(new Pair<>(word, pair.getValue() + 1));
                        visited.put(word, pair.getValue() + 1);
                    }
                }
            }
        }
        return -1;
    }
}
