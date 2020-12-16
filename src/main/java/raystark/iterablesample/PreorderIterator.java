package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

//参考 http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-ii.html
final class PreorderIterator<T> implements Iterator<T> {
    private final Deque<Node<T>> stack;

    PreorderIterator(@NotNull Option<Node<T>> root) {
        this.stack = new ArrayDeque<>();
        root.ifPresent(stack::push);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public @NotNull T next() {
        return Option.ofNullable(stack.poll())
            .whenPresent(node -> node.getRight().ifPresent(stack::push))
            .whenPresent(node -> node.getLeft().ifPresent(stack::push))
            .orElseThrow()
            .value();
    }
}
