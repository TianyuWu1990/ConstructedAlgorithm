package BFS;

import java.util.*;

public class MyBFSMethods {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
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


    public Node cloneGraph(Node node) {
        // BFS
        if (node == null) return null;

        Node newNode = new Node(node.val, new ArrayList<Node>()); //new node for return
        HashMap<Integer, Node> map = new HashMap(); //store visited nodes

        map.put(newNode.val, newNode); //add first node to HashMap

        LinkedList<Node> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue

        while (!queue.isEmpty()) { //if more nodes need to be visited
            Node n = queue.pop(); //search first node in the queue
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.val)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.add(neighbor);
                }
                map.get(n.val).neighbors.add(map.get(neighbor.val)); //add neighbor to new created nodes
            }
        }

        return newNode;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        // null case
        if(s == null || wordDict.size() == 0){
            return false;
        }

        int maxWordLength = 0;
        for(String str: wordDict){
            maxWordLength = str.length() > maxWordLength? str.length() : maxWordLength;
        }

        //1. state: boolean f[i] = true, wordDict contains s.substring(0, i)
        boolean[] f = new boolean[s.length() + 1]; // s is non-empty
        //2. initialize
        f[0] = true;
        for(int i=1; i<=s.length(); i++){

            // number of subproblems: i
            for(int j=0; j<i; j++){
                //3. state transfer function
                //the left  segmentation: f[j]
                //the right segmentation: s.substring(j, i)

                // 3 improvements: (remove redundant operations)
                // improve 1: if f[j] is false, no need to check the right segment
                if(!f[j]){
                    continue;
                }

                // improve 2: if the length of right segment is more than the maximum length
                if(i-j > maxWordLength){
                    continue;
                }

                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    //improve 3:wordDict={"a", "bc", "ab", "c"}
                    // when "abc"="a" + "bc"; return true, no need to check: "abc"="ab" + "c";
                    break;
                }
            }
        }
        // 4. return
        return f[s.length()];
        // HashSet<String> set = new HashSet<>(wordDict);
        // int[] visited = new int[s.length()]; //start point
        // Queue<Integer> q = new LinkedList<>();
        // q.add(0);
        // while (!q.isEmpty()) {
        //     int start = q.remove();
        //     if (visited[start] == 0) { // not been visited
        //         for (int end = start; end <= s.length(); end++) {
        //             if (set.contains(s.substring(start, end))) {
        //                 q.add(end);
        //                 if (end == s.length()) {
        //                     return true;
        //                 }
        //             }
        //         }
        //         visited[start] = 1;
        //     }
        // }
        // return false;
    }


}
