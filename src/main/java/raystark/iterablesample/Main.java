package raystark.iterablesample;

import raystark.eflib.option.Option.Some;

public class Main {
    public static void main(String[] args) {
        var tree = new BinaryTree<>(
            Some.of(new Node<>(6,
                Some.of(new Node<>(2,
                    Some.of(new Node<>(1)),
                    Some.of(new Node<>(4,
                        Some.of(new Node<>(3)),
                        Some.of(new Node<>(5))
                    ))
                )),
                Some.of(new Node<>(10,
                    Some.of(new Node<>(8,
                        Some.of(new Node<>(7)),
                        Some.of(new Node<>(9))
                    )),
                    Some.of(new Node<>(11))
                ))
            )
        ));

        System.out.println("Preorder");
        for(var value : tree.preorderIterable())
            System.out.print(" " + value);
        System.out.println();

        System.out.println("Inorder");
        for(var value : tree.inorderIterable())
            System.out.print(" " + value);
        System.out.println();

        System.out.println("Postorder");
        for(var value : tree.postorderIterable())
            System.out.print(" " + value);
        System.out.println();

        System.out.println("BreathFirst");
        for(var value : tree.breadthFirstIterable())
            System.out.print(" " + value);
        System.out.println();
    }
}
