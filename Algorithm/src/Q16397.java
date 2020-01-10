import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Q16397 {
   static boolean visited[] = new boolean[100000];
   static int min = Integer.MAX_VALUE;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str[] = br.readLine().split(" ");
      
      int N = Integer.valueOf(str[0]);
      int T = Integer.valueOf(str[1]);
      int G = Integer.valueOf(str[2]);
      
      Queue<Button> queue = new LinkedList<Button>();
      
      queue.add(new Button(N, 0));
      visited[N] = true;
      
      while(!queue.isEmpty()) {
         Button btn = queue.poll();
         
         if(btn.count > T) {
            continue;
         }
         if(btn.cur == G) {
            min = Math.min(min, btn.count);
            continue;
         }
         
         int next = btn.cur;
         next++;
         if(next != 100000) {
            if(visited[next] == false) {
               visited[next] = true;
               queue.add(new Button(next, btn.count + 1));
            }
         }
         
         next = btn.cur;
         next = next * 2;
         if(next < 100000) {
            if(next != 0) {
               String value = next + "";                              //1234
               value = (value.charAt(0)-'0'-1) + value.substring(1);  //0234
               next = Integer.valueOf(value);
            }
            
            if(visited[next] == false) {
               visited[next] = true;
               queue.add(new Button(next, btn.count + 1));
            }
         }
      }
      
      if(min == Integer.MAX_VALUE) {
         System.out.println("ANG");
      }
      else {
         System.out.println(min);
      }
   }
}

class Button {
   int cur, count;
   public Button(int cur, int count) {
      this.cur = cur;
      this.count = count;
   }
}