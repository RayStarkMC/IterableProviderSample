package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

public class BinaryTree<T> {
    private final Option<Node<T>> root;

    public BinaryTree(@NotNull Option<Node<T>> root) {
        this.root = root;
    }

    private @NotNull Option<Node<T>> root() {
        return this.root;
    }

    public @NotNull Iterable<T> preorderIterable() {
        return () -> new PreorderIterator<>(root());
    }

    public @NotNull Iterable<T> inorderIterable() {
        return () -> new InorderIterator<>(root());
    }

    public @NotNull Iterable<T> postorderIterable() {
        return () -> new PostorderIterator<>(root());
    }

    public @NotNull Iterable<T> breadthFirstIterable() {
        return () -> new BreadthFirstIterator<>(root());
    }
}
