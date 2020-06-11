#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

struct Node {
    char c;
    unordered_map<char, Node*> children;
    Node(char pc) { c = pc; }
};

void print(Node* node) {
    cout << node->c << "->[";
    for (pair<char, Node*> ch : node->children) {
        print(ch.second);
        cout << ", ";
    }
    cout << "]";
}

int main() {
    string s;
    cin >> s;
    string t;
    cin >> t;
    bool bad[26];
    for (int i = 0; i < 26; i++) {
        bad[i] = (t[i] == '0');
    }
    int k;
    cin >> k;
    Node root('X');
    int n = s.size();
    int nodeCount = 0;
    for (int i = 0; i < n; i++) {
        Node* curr = &root;
        int badCount = 0;
        for (int j = i; j < n; j++) {
            char c = s[j];
            if (bad[c - 'a']) {
                badCount++;
            }
            if (badCount > k) {
                break;
            }
            if (curr->children.find(c) == curr->children.end()) {
                curr->children[c] = new Node(c);
                nodeCount++;
            }
            curr = curr->children[c];
        }
    }
    // print(&root);
    // cout << "\n";
    cout << nodeCount << "\n";
}
