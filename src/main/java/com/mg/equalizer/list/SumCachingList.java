package com.mg.equalizer.list;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SumCachingList implements SummingList {
    private final List<Integer> decorated;

    public SumCachingList(List<Integer> decorated) {
        this.decorated = decorated;
    }

    public static SummingList of(List<Integer> decorated) {
        return new SumCachingList(decorated);
    }

    public static SummingList of(Integer... elements) {
        return new SumCachingList(new ArrayList<>(Arrays.asList(elements)));
    }

    public static SummingList emptyList() {
        return of(Collections.emptyList());
    }

    private int sum;
    private boolean sumCalculated = false;

    @Override
    public int sum() {
        if (!sumCalculated) {
            calculateSum();
            sumCalculated = true;
        }
        return sum;
    }

    private void calculateSum() {
        for (var i : decorated) {
            sum += i;
        }
    }

    @Override
    public int size() {
        return decorated.size();
    }

    @Override
    public boolean isEmpty() {
        return decorated.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return decorated.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return decorated.iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        decorated.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return decorated.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return decorated.toArray(a);
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return SummingList.super.toArray(generator);
    }

    @Override
    public boolean add(Integer integer) {
        sum = +sum() + integer;
        return decorated.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        var removed = decorated.remove(o);
        if (removed) {
            sum = sum() - (Integer) o;
        }
        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return decorated.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        var sumOfNewElements = 0;
        for (var i : c) {
            sumOfNewElements += i;
        }
        sum = sum() + sumOfNewElements;
        return decorated.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        var sumOfNewElements = 0;
        for (var i : c) {
            sumOfNewElements += i;
        }
        sum = sum() + sumOfNewElements;
        return decorated.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        sumCalculated = false;
        var anyRemoved = decorated.removeAll(c);
        if (anyRemoved) {
            sumCalculated = false;
        }
        return anyRemoved;
    }

    @Override
    public boolean removeIf(Predicate<? super Integer> filter) {
        var anyRemoved = decorated.removeIf(filter);
        if (anyRemoved) {
            sumCalculated = false;
        }
        return anyRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        var anyChanged = decorated.retainAll(c);
        if (anyChanged) {
            sumCalculated = false;
        }
        return anyChanged;
    }

    @Override
    public void replaceAll(UnaryOperator<Integer> operator) {
        sumCalculated = false;
        decorated.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Integer> c) {
        decorated.sort(c);
    }

    @Override
    public void clear() {
        decorated.clear();
        sumCalculated = true;
    }

    @Override
    public Integer get(int index) {
        return decorated.get(index);
    }

    @Override
    public Integer set(int index, Integer element) {
        sum = sum() - decorated.get(index);
        sum = sum() + element;
        return decorated.set(index, element);
    }

    @Override
    public void add(int index, Integer element) {
        sum = sum() + element;
        decorated.add(index, element);
    }

    @Override
    public Integer remove(int index) {
        var result = decorated.remove(index);
        sum = sum() - result;
        return result;
    }

    @Override
    public int indexOf(Object o) {
        return decorated.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return decorated.lastIndexOf(o);
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return decorated.listIterator();
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return decorated.listIterator(index);
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return decorated.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return decorated.spliterator();
    }

    @Override
    public Stream<Integer> stream() {
        return decorated.stream();
    }

    @Override
    public Stream<Integer> parallelStream() {
        return decorated.parallelStream();
    }

    @Override
    public String toString() {
        return decorated.toString();
    }
}
