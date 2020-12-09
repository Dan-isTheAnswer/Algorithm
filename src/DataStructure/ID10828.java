package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class ID10828 {
    // Problems and Answers
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private Stack<String> stack;

    private ID10828() {
        stack = new Stack<>();
    }

    public static void main(String[] args) throws IOException {
        ID10828 thisis = new ID10828();

        int n = Integer.parseInt(br.readLine());

        while(n-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    thisis.stack.push(st.nextToken());
                    break;
                case "top":
                    if(thisis.stack.isEmpty()) {
                        sb.append("-1\n");
                    } else{
                        String str = thisis.stack.peek();
                        sb.append(str+"\n");
                    }
                    break;
                case "size":
                    sb.append(thisis.stack.size()+"\n");
                    break;
                case "pop":
                    if(thisis.stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(thisis.stack.pop()+"\n");
                    }
                    break;
                case "empty":
                    if (thisis.stack.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
            
                default:
                    break;
            }
        }
        
        System.out.println(sb); 
    }
}