package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

public final class BinaryTree<T> {
    private final Option<Node<T>> root;

    public BinaryTree(@NotNull Option<Node<T>> root) {
        this.root = root;
    }

    public @NotNull Option<Node<T>> root() {
        return this.root;
    }

    public @NotNull Iterable<T> preorderIterable() {
        return () -> new PreorderIterator<>(this);
    }

    public @NotNull Iterable<T> inorderIterable() {
        return () -> new InorderIterator<>(this);
    }

    public @NotNull Iterable<T> postorderIterable() {
        return () -> new PostorderIterator<>(this);
    }

    public @NotNull Iterable<T> breadthFirstIterable() {
        return () -> new BreadthFirstIterator<>(this);
    }
}
