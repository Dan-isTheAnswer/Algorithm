package STR;

import java.util.LinkedList;

class ID9012adv1 {

    private static class Stack {
        private LinkedList<Character> list = new LinkedList<>();

        // public char top() {
        //     return list.getFirst();
        // }
        
        public void push(char e) {
            list.addFirst(e);
        }

        public char pop() {
            return list.removeFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
    
    public static void main(String[] args) {
        // int n = 4;
        String[] input = new String[] { // len is n
            "((","))","())(()","(()())((()))"
        };

        solve(input);
    }

    private static void solve(String[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            Stack st = new Stack();
            boolean isOver = false;
            for (int j = 0; j < input[i].length(); j++) {
                if (input[i].charAt(j) == '(') {
                    st.push('(');
                } else if (input[i].charAt(j) == ')') {
                    if (st.isEmpty()){
                        isOver = true;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if (isOver || !st.isEmpty()) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }

        }

        System.out.println(sb.toString());

    }
}
