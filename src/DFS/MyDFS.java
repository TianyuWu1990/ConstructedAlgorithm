package DFS;

public class MyDFS {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid =
                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
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


    /**
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length==0) return;
        int rows = board.length;
        int cols = board[0].length;
        //dfs from 1st and last rows
        for(int j=0; j<cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows-1, j);
        }
        //dfs from 1st and last cols
        for(int i=0; i<rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols-1);
        }

        //postprocessing, flip Os that are not connected with borders
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j]!='#')
                    board[i][j] = 'X';
                else
                    board[i][j] = 'O';
            }
        }
    }

    //mark all Os connected with border with #
    public void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        if(i<0||i>rows-1||j<0||j>cols-1||board[i][j]!='O') return;
        board[i][j] = '#';

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int k=0; k<dx.length; k++) {
            dfs(board, i+dx[k], j+dy[k]);
        }
    }



}
