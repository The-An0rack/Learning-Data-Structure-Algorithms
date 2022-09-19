//Link: https://practice.geeksforgeeks.org/problems/sort-a-stack/1

//{ Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class SortedStack{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                Stack<Integer> s=new Stack<>();
                int n=sc.nextInt();
                while(n-->0)
                s.push(sc.nextInt());
                GfG g=new GfG();
                Stack<Integer> a=g.sort(s);
                while(!a.empty()){
                    System.out.print(a.peek()+" ");
                    a.pop();
                }
                System.out.println();
            }
            sc.close();
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG{
        
        Stack<Integer> sortedInsert(Stack<Integer> s, Integer ele) {
            if(s.isEmpty() || s.peek() < ele) {
                s.push(ele);
                return s;
            }
            
            Integer temp = s.pop();
            s = sortedInsert(s,ele);
            s.push(temp);
            return s;
        }
        
        public Stack<Integer> sort(Stack<Integer> s)
        {
            if(s.isEmpty()) {
                return s;
            }
            
            Integer temp = s.pop();
            s = sort(s);
            sortedInsert(s,temp);
            return s;
        }
    }