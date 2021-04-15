#include <iostream>
#include <string>
#include <vector>

using namespace std;
class Trie {
private:
    vector<string> vector;
public:
    /** Initialize your data structure here. */
    Trie() {

    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        if (vector.empty()) {
            vector.push_back(word);
            return;
        }
        if (!search(word)) {
            vector.push_back(word);
        }
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        for(int i = 0; i < vector.size(); i++) {
            if (vector[i] == word) {
                return true;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        for(int i = 0; i < vector.size(); i++) {
            int j;
            for(j = 0; j < vector[i].size() && j < prefix.size(); j++) {
                if (prefix[j] != vector[i][j]) {
                    break;
                }
            }
            if (j == prefix.size()) {
                return true;
            }
        }
        return false;
    }
};

int main() {
    Trie *trie = new Trie();
    trie->insert("apple");
    trie->search("apple");
    trie->search("app");
    trie->startsWith("app");
    trie->insert("app");
    trie->search("app");
    return 0;
}