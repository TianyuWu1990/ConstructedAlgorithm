package BFS;

public class MyBFSMethods {
    /**
     * WordLadder I find minimal path
     * @param start
     * @param end
     * @param wordList
     * @return
     */
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (dict.isEmpty()) {
            return 0;
        }

        int length = 1;
        if (start.equals(end)) {
            return length;
        }

        dict.add(start);

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            // current level
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNextWords(cur, dict)) {
                    if (!visited.contains(next)) {
                        if (next.equals(end)) {
                            return length;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return 0;
    }
    private String replace(String s, int index, char c) {
        char[] newArr = s.toCharArray();
        newArr[index] = c;
        return new String(newArr);
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != word.charAt(i)) {
                    String nextWord = replace(word, i, c);
                    if (dict.contains(nextWord)) {
                        nextWords.add(nextWord);
                    }
                }

            }
        }
        return nextWords;
    }

    /**
     * Word Ladder II
     */
    // final result
    List<List<String>> res = new ArrayList<>();
    // temp list for backtrack
    List<String> list = new LinkedList<>();
    // <mutation: list<father>>
    Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return res;
        // BFS each mutation
        Queue<String> q = new ArrayDeque<>();
        // temp visited
        Set<String> visited = new HashSet<>();
        // unmutable unvisited
        Set<String> unvisited = new HashSet<>(wordList);
        q.add(beginWord);
        // remove the begin word first
        unvisited.remove(beginWord);
        boolean found = false;

        // bfs
        while(!q.isEmpty()) {
            int size = q.size();
            //current level
            for (int k = size - 1; k >= 0; k--) { // for each string in the queue
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    // change one char a time then make new string to compare
                    char chs[] = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String newStr = new String(chs);
                        // if mutation is unvisted
                        if (unvisited.contains(newStr)) {
                            // update the visited and add to queue for next validation
                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                q.add(newStr);
                            }
                            // build adjacent graph
                            //<mutation, fathers>
                            if (map.containsKey(newStr)) map.get(newStr).add(word);
                            else {
                                List<String> l = new ArrayList<>();
                                l.add(word);
                                map.put(newStr, l);
                            }
                            if (newStr.equals(endWord)) found = true;
                        }
                    }//a-z
                }//first index-last index
            }//for each string
            if (found) break;
            // unvisted is unmutable
            unvisited.removeAll(visited);
            // queue's visited need to rebuild
            visited.clear();

        }

        // back trace based on the adjacent graph that we have built
        backTrace(endWord, beginWord);
        return res;
    }

    private void backTrace(String cur, String start) {
        if (cur.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<String>(list));
            list.remove(0); // backtrace by one step
            return;
        }
        list.add(0, cur);
        if (map.get(cur) != null) {
            for (String s:map.get(cur)) { // for each neighbors
                //set cur to its every father
                backTrace(s,start);
            }
        }
        list.remove(0);
    }


}
