package kata.stak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StackTest {
    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack(5);
    }

    @Test
    void newly_created_stacks_should_be_empty() {
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void after_one_push_stack_size_should_be_one() {
        stack.push("A");
        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void after_one_push_and_one_pop_stack_should_be_empty() {
        stack.push("A");
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void when_pushed_passed_limit_throw_stack_overflows_exception() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E ");
        assertThatExceptionOfType(StackOverflowException.class)
                .isThrownBy(() -> stack.push("F"));
    }

    @Test
    void When_popped_passed_limit_stack_underflow() {
        stack.push("A");
        stack.push("B");
        stack.pop();
        stack.pop();
        assertThatExceptionOfType(StackOverflowException.class)
                .isThrownBy(() -> stack.pop());
    }

    @Test
    void When_two_values_are_pushed_then_one_is_popped_size_is_one() {
        stack.push("A");
        stack.push("B");
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void When_value_is_pushed_value_is_popped() {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        assertThat(stack.getElements()).isEqualTo(list);
    }
}
