package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

//参考 http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-iii.html
final class PostorderIterator<T> implements Iterator<T> {
    private final Deque<Node<T>> stack;

    PostorderIterator(@NotNull Option<Node<T>> root) {
        this.stack = new ArrayDeque<>();
        root.repeatMapWithSideEffect(this::down, stack::push)
            .ifPresent(stack::push);
    }

    private Option<Node<T>> tryFilterLeft(Node<T> leaf) {
        return Option.ofNullable(stack.peek())
            .filter(parent -> parent.getLeft().anyMatch(left -> leaf == left));
    }

    private Option<Node<T>> down(Node<T> node) {
        return node.getLeft().or(node.getRight());
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        return Option.ofNullable(stack.poll())
            .whenPresent(
                leaf -> this.tryFilterLeft(leaf)
                    .flatMap(Node::getRight)
                    .repeatMapWithSideEffect(this::down, stack::push)
                    .ifPresent(stack::push)
            ).orElseThrow()
            .value();
    }
}
