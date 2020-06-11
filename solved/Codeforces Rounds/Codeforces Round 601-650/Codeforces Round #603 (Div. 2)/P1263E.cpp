#include <cstring>
#include <iostream>
#include <stack>

#ifdef LOCAL
#define DEBUG 1
#include <cstdarg>
#else
#define DEBUG 0
#endif

#define debug(v)                                     \
    {                                                \
        if (DEBUG) cout << #v << " = " << v << "\n"; \
    }

using namespace std;

inline bool is_bracket(char c) { return c == ')' || c == '('; }

void print_buffer(char* buffer, int len, int pos, int ppos) {
    for (int i = 0; i < len; i++) {
        printf("%c", buffer[i] ? buffer[i] : ' ');
    }
    printf("\n");
    for (int i = 0; i < len; i++) {
        if (i == pos) {
            printf("^");
        } else if (i == ppos) {
            printf("~");
        } else {
            printf(" ");
        }
    }
    printf("\n");
}

struct aux {
    char c;
    int depth;
    int max_depth;
    int min_depth;
} zero = {0, 0, 0, 0};

class buffer_stack {
    stack<aux> stack;

   public:
    void push(char c) {
        aux top = stack.empty() ? zero : stack.top();
        int depth = top.depth + (c == ')' ? -1 : 1);
        if (DEBUG) {
            printf("(d=%d, M=%d, m=%d) -> (d=%d, M=%d, m=%d)\n", top.depth,
                   top.max_depth, top.min_depth, depth,
                   max(top.max_depth, depth), min(top.min_depth, depth));
        }
        stack.push(
            {c, depth, max(top.max_depth, depth), min(top.min_depth, depth)});
    }

    aux top() { return stack.empty() ? zero : stack.top(); }

    void pop() { stack.pop(); }
};

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) {
        freopen("../input.txt", "r", stdin);
    }
    int n;
    cin >> n;
    string s;
    cin >> s;
    int pos = 0;
    char buffer[n + 1];
    memset(buffer, 0, n + 1);
    buffer_stack left, right;
    int len = 1;
    int counter = 1;
    for (char c : s) {
        char curr = buffer[pos];
        int ppos = pos;
        switch (c) {
            case 'L':
                if (pos > 0) {
                    if (is_bracket(curr)) {
                        right.push(curr);
                        left.pop();
                    }
                    pos--;
                    curr = buffer[pos];
                }
                break;
            case 'R':
                pos++;
                curr = buffer[pos];
                if (pos < len) {
                    if (is_bracket(curr)) {
                        left.push(curr);
                        right.pop();
                    }
                } else {
                    len++;
                }
                break;
            default:  // a-z,(,)
                if (is_bracket(curr)) {
                    left.pop();
                }
                buffer[pos] = c;
                curr = buffer[pos];
                if (is_bracket(c)) {
                    left.push(c);
                }
                break;
        }
        auto lt = left.top(), rt = right.top();
        if (DEBUG) {
            print_buffer(buffer, len, pos, ppos);
            printf(
                "[%d] input='%c', lt = (%d, %d, %d), rt = (%d, %d, %d), ans = ",
                counter++, c, lt.depth, lt.max_depth, lt.min_depth, rt.depth,
                rt.max_depth, rt.min_depth);
        }
        if (lt.depth >= 0 && rt.depth <= 0 && lt.min_depth >= 0 &&
            rt.max_depth <= 0 && lt.depth + rt.depth == 0) {
            printf("%d ", max(lt.depth, max(lt.max_depth, -rt.min_depth)));
        } else {
            printf("-1 ");
        }
        if (DEBUG) {
            printf("\n---\n");
        }
    }
    printf("\n");
    return 0;
}