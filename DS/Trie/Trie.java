import java.util.Map;
import java.util.HashMap;

class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char s = word.charAt(i);

			TrieNode t;

			if (children.containsKey(s)) {
				t = children.get(s);
			} else {
				t = new TrieNode(s);
				children.put(s, t);
			}
			children = t.children;

			if (i == word.length() - 1) {
				t.isLeaf = true;
			}
		}
	}

	public TrieNode searchNode(String word) {
		Map<Character, TrieNode> children = root.children;

		TrieNode t = null;

		for (int i = 0; i < word.length(); i++) {
			char c  = word.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}
		return t;
	}

	public boolean startsWith(String prefix) {
		TrieNode t = searchNode(prefix);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean search(String word) {
		if (searchNode(word) != null && ) {
			return true;
		} else {
			return false;
		}
	}

	public List<String> getWordsFromPrefix(String prefix){
		List<String> wordList =  new ArrayList<String>();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("ass");
		trie.insert("asshole");

		System
	}
}