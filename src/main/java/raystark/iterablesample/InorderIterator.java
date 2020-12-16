package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// 参考 http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-i-in.html
final class InorderIterator<T> implements Iterator<T> {
    private final Deque<Node<T>> stack;

    InorderIterator(@NotNull Option<Node<T>> root) {
        this.stack = new ArrayDeque<>();
        root.repeatMapWithSideEffect(Node::getLeft, stack::push).ifPresent(stack::push);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        return Option.ofNullable(stack.poll())
            .whenPresent(
                leaf -> leaf.getRight()
                    .repeatMapWithSideEffect(Node::getLeft, stack::push)
                    .ifPresent(stack::push)
            ).orElseThrow()
            .value();
    }
}
