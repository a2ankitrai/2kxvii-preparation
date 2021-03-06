# Trie
---

A trie, also called digital tree and sometimes radix tree or prefix tree. An ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings.

Using trie, search complexities can be brought to optimal limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to **M * log N**, where M is maximum string length and N is number of keys in tree. Using trie, we can search the key in O(M) time. However the penalty is on trie storage requirements.

