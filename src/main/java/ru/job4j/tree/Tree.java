package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        Predicate<Node<E>> condition = eNode -> eNode.getChildren().size() > 2;
        return findByPredicate(condition).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> optionalParent = findBy(parent);
        Optional<Node<E>> optionalChild = findBy(child);
        if (optionalParent.isPresent() && optionalChild.isEmpty()) {
            optionalParent.get().getChildren().add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> condition = eNode -> eNode.getValue().equals(value);
        return findByPredicate(condition);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}