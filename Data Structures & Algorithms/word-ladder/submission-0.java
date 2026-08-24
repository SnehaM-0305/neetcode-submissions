class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // create graph using map
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            int n = word.length();

            for (int i = 0; i < n; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());
                }

                map.get(pattern).add(word);
            }
        }

        // using BFS

        int level = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                // if not search in its neobhours
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                    List<String> nebb = map.get(pattern);
                    if(nebb==null){
                        continue ; 
                    }

                    for (String neb : nebb) {
                        if(!visited.contains(neb)){
                            q.add(neb) ; 
                            visited.add(neb) ; 
                        }


                    }
                }
            }
            level++ ; 
        }

        return 0 ; 
    }
}
