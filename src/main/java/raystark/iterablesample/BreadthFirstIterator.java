package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

final class BreadthFirstIterator<T> implements Iterator<T> {
    private final Queue<Node<T>> queue;

    BreadthFirstIterator(@NotNull BinaryTree<T> tree) {
        queue = new ArrayDeque<>();
        tree.root().ifPresent(queue::offer);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        return Option.ofNullable(queue.poll())
            .whenPresent(polledNode -> {
                polledNode.getLeft().ifPresent(queue::offer);
                polledNode.getRight().ifPresent(queue::offer);
            })
            .orElseThrow()
            .value();
    }
}
