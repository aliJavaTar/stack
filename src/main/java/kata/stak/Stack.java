package kata.stak;

import java.util.LinkedList;
import java.util.List;

public class Stack {
    private final List<String> elements;
    private int limit;

    public Stack(int capacity) {
        limit = capacity;
        this.elements = new LinkedList<>();
    }

    public int getSize() {
        return elements.size();
    }

    public void push(String element) {
        if (elements.size() >= limit) {
            throw new StackOverflowException("You passed the limit of stack which is : " + limit);
        }
        elements.add(element);
    }

    public List<String> getElements() {
        return elements;
    }
  public void ali()
  {
      System.out.println("ali");
  }
    /*
         A
         B
         C
         D
         E
         */
    public void pop() {
        if (getSize() <= 0)
            throw new StackOverflowException("When popped passed limit, stack underflows");
        elements.remove(getSize() - 1);
    }
}
