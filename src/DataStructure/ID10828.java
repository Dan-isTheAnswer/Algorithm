package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ID10828 {
    private static ArrayList<String> arr;
    private static StringBuilder sb;

    private ID10828() {
        arr = new ArrayList<>();
        sb = new StringBuilder();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        new ID10828();

        while(n-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    push(st.nextToken()); 
                    break;
                case "top":
                    top();
                    break;
                case "size":
                    size();
                    break;
                case "pop":
                    pop();
                    break;
                case "empty":
                    empty();
                    break;
            
                default:
                    break;
            }
        }
        
        System.out.println(sb); 
    }

    private static void push(String input) {
        arr.add(input);
    }

    private static void pop() {
        if (!arr.isEmpty()) {
            sb.append(arr.get(arr.size()-1)+ "\n");
            arr.remove(arr.size()-1);
        } else {
            sb.append("-1\n");
        }
    }

    private static void size() {
        sb.append(arr.size()+"\n");
    }

    private static void empty() {
        // if empty : 1; if not empty : 0
        if(arr.isEmpty()) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    private static void top() {
        sb.append(arr.get(arr.size()-1)+"\n");
    }
}
