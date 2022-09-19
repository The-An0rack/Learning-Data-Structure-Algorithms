//Link: https://www.codingninjas.com/codestudio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166?leftPanelTab=1

import java.util.*;

class Solution 
{
  public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) 
  {
       if(myStack.isEmpty()) {
            myStack.push(x);
           return myStack;
       }
          
        Integer temp = myStack.pop();
        pushAtBottom(myStack,x);
        myStack.push(temp);
        return myStack;
  }
}
