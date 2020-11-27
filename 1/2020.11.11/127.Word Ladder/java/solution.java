class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> front = new HashSet<>();
        front.add(beginWord);
        Set<String> back = new HashSet<>();
        back.add(endWord);
        
        int wordLength = beginWord.length();
        int dist = 1;
        while (!front.isEmpty()) {
            dist++;
            Set<String> nextFront = new HashSet<>();
            for (String word : front) {
                for (int i = 0; i < wordLength; i++) {
                    for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                        if (c != word.charAt(i)) {
                            String newWord = word.substring(0, i) + String.valueOf(c) + word.substring(i+1);
                            if (back.contains(newWord)) {
                                return dist;
                            }
                            if (wordSet.contains(newWord)) {
                                nextFront.add(newWord);
                                wordSet.remove(newWord);
                            }
                        }
                    }
                }
            }
            front = nextFront;
            if (back.size() < front.size()) {
                Set<String> tmp = front;
                front = back;
                back = tmp;
            }
        }
        return 0;
    }
}
