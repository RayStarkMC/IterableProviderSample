package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;

public final class BinaryTree<T> {
    private final Option<Node<T>> root;

    private final Iterable<T> preorder;
    private final Iterable<T> inorder;
    private final Iterable<T> postorder;
    private final Iterable<T> breadthFirst;

    public BinaryTree(@NotNull Option<Node<T>> root) {
        this.root = root;
        this.preorder = () -> new PreorderIterator<>(this);
        this.inorder = () -> new InorderIterator<>(this);
        this.postorder = () -> new PostorderIterator<>(this);
        this.breadthFirst = () -> new BreadthFirstIterator<>(this);
    }

    public @NotNull Option<Node<T>> root() {
        return this.root;
    }

    public @NotNull Iterable<T> preorderIterable() {
        return preorder;
    }

    public @NotNull Iterable<T> inorderIterable() {
        return inorder;
    }

    public @NotNull Iterable<T> postorderIterable() {
        return postorder;
    }

    public @NotNull Iterable<T> breadthFirstIterable() {
        return breadthFirst;
    }
}
