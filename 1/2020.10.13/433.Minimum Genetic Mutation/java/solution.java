class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] ca = {'A', 'C', 'G', 'T'};
        Deque<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offerLast(start);
        visited.add(start);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size-- > 0) {
                String word = q.pollFirst();
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char old = wordArray[i];
                    for (int j = 0; j < ca.length; j++) {
                        wordArray[i] = ca[j];
                        String newWord = new String(wordArray);
                        if (newWord.equals(end)) {
                            return level;
                        }
                        if (!visited.contains(newWord) && bankSet.contains(newWord)) {
                            q.offerLast(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArray[i] = old;
                }
            }
        }
        return -1;
    }
}
