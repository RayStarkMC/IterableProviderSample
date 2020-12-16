package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

final class BreadthFirstIterator<T> implements Iterator<T> {
    private final Queue<Node<T>> queue;

    BreadthFirstIterator(@NotNull Option<Node<T>> root) {
        queue = new ArrayDeque<>();
        root.ifPresent(queue::offer);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        return Option.ofNullable(queue.poll())
            .whenPresent(node -> node.getLeft().ifPresent(queue::offer))
            .whenPresent(node -> node.getRight().ifPresent(queue::offer))
            .orElseThrow()
            .value();
    }
}
