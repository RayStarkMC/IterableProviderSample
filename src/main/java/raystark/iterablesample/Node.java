package raystark.iterablesample;

import org.jetbrains.annotations.NotNull;
import raystark.eflib.option.Option;
import raystark.eflib.option.Option.None;

public final class Node<T> {
    private final T value;
    private final Option<Node<T>> left;
    private final Option<Node<T>> right;

    public Node(@NotNull T value, @NotNull Option<Node<T>> left, @NotNull Option<Node<T>> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(@NotNull T value) {
        this(value, None.of(), None.of());
    }

    @NotNull public T value() { return value; }
    @NotNull public Option<Node<T>> getLeft() { return left; }
    @NotNull public Option<Node<T>> getRight() { return right; }
}
