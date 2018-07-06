package com.list.stream.filter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterTest {

    private static List<Item> items;

    static {
        items = Arrays.asList(
                new Item(2, "apple", 10, new BigDecimal("9.99")),
                new Item(23, "banana", 20, new BigDecimal("19.99")),
                new Item(34, "orang", 10, new BigDecimal("29.99")),
                new Item(342, "watermelon", 10, new BigDecimal("29.99")),
                new Item(25, "papaya", 20, new BigDecimal("9.99")),
                new Item(234, "apple", 10, new BigDecimal("9.99")),
                new Item(233, "banana", 10, new BigDecimal("19.99")),
                new Item(23, "apple", 20, new BigDecimal("9.99"))
        );
    }

    public static void main(String[] args) {
        exemplo1();
        exemplo2();
        exemplo3();
        exemplo4();
    }

    public static void exemplo1() {
        List<Item> collect = items.stream().filter(Item.like("ap").or(Item.like("ba"))).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void exemplo2() {
        List<Item> items = Arrays.asList(
                null,
                null,
                null,
                new Item(342, "watermelon", 10, new BigDecimal("29.99")),
                null,
                new Item(234, "apple", 10, new BigDecimal("9.99")),
                null,
                null
        );
        List<Item> collect = items.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void exemplo3() {
        Item pessoa = items.stream().filter(Item.codigo(11)).findAny().orElse(null);
        System.out.println(pessoa);
    }

    public static void exemplo4() {
        List<String> items = Arrays.asList("", "apple", " ", "  ", "   ", "orange", null);
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t != null && !t.trim().equals("");
            }
        };
        List<String> collect = items.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void exemplo5() {

        items.stream().forEach(item -> {
            System.err.println(item);
        });
    }
}

class Item {

    private Integer codigo;
    private String name;
    private int qty;
    private BigDecimal price;

    public Item(Integer codigo, String name, int qty, BigDecimal price) {
        this.codigo = codigo;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public static Predicate<Item> codigo(Integer codigo) {
        Predicate<Item> predicate = new Predicate<Item>() {
            @Override
            public boolean test(Item x) {
                return x.getCodigo().equals(codigo);
            }
        };
        return predicate;
    }

    public static Predicate<Item> like(String string) {

        Predicate<Item> predicate = new Predicate<Item>() {

            @Override
            public boolean test(Item x) {
                //x.getNome().startsWith(string); // like "dig%"
                //x.getNome().endsWith(string); // like "%tal"
                //x.getNome().contains(string); // like "%gita%"
                return x.getName().startsWith(string);
            }
        };
        return predicate;
    }

    public Integer getCodigo() {
        return codigo;
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
        return "Item{" + "codigo=" + codigo + ", name=" + name + ", qty=" + qty + ", price=" + price + '}';
    }
}
