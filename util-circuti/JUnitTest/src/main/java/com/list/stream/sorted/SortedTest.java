package com.list.stream.sorted;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedTest {

    private static List<Item> items = new ArrayList<>();

    static {
        items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
    }

    public static void main(String[] args) {
        exemplo1();
        exemplo2();
    }

    public static void exemplo1() {
        List<Item> collect = items.stream().sorted(Item.comparatorNome()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void exemplo2() {
        List<Item> collect = items.stream().sorted(Item.comparatorNome().reversed()).collect(Collectors.toList());
        System.out.println(collect);
    }
}

class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public static Comparator<Item> comparatorNome() {
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        return comparator;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", qty=" + qty + ", price=" + price + '}';
    }
}
