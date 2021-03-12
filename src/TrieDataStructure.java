public class TrieDataStructure {
    public static class TrieNode{
        public TrieNode[] children;
        public boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    public static class Trie{
        public TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void add(String s){
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                if (temp.children[s.charAt(i)-'a'] == null){
                    temp.children[s.charAt(i)-'a'] = new TrieNode();
                }
                temp = temp.children[s.charAt(i)-'a'];
            }
            temp.isEnd = true;
        }
        public boolean search(String s){
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                if (temp.children[s.charAt(i)-'a'] == null)
                    return false;
                temp = temp.children[s.charAt(i)-'a'];
            }
            return temp.isEnd;
        }
    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("better");
        trie.add("betting");

        System.out.println(trie.search("bet"));
        System.out.println(trie.search("apple"));
    }
}
