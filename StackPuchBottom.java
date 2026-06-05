import java.util.Stack;
public class StackPuchBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Original Stack: " + stack);
        pushBottom(stack, 0);
        System.out.println("Stack after pushing 0 at the bottom: " + stack);
    }

    public static void pushBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        pushBottom(stack, value);
        stack.push(top);
    }

}



