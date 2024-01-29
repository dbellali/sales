package com.risf;

import java.util.ArrayList;
import java.util.List;

import com.risf.enumeration.TaxEnum;
import com.risf.model.Category;
import com.risf.model.Item;
import com.risf.model.Receipt;
import com.risf.service.ReceiptService;

public class Main {
    public static void main(String[] args) {
        System.out.println("##########################################");
        test1();
        System.out.println("##########################################");
        test2();
        System.out.println("##########################################");
        test3();
        System.out.println("##########################################");
    }

    public static void test1() {
        ReceiptService receiptService = ReceiptService.getInstance();

        Category category1 = new Category("book", TaxEnum.NO_TAX);
        Category category2 = new Category("food", TaxEnum.NO_TAX);
        Category category3 = new Category("other", TaxEnum.BASIC_TAX);

        Item item1 = new Item("book", 12.49, category1);
        Item item2 = new Item("music CD", 14.99, category3);
        Item item3 = new Item("chocolate bar", 0.85, category2);
        System.out.println(item1);

        Receipt receipt = new Receipt();
        receipt.addItem(List.of(item1, item2, item3));
        receiptService.printReceiptInput(receipt);
        System.out.println("-----------------------------------");
        receiptService.printReceiptOutput(receipt);
        // System.out.print("Sales Taxs : " +
        // receiptService.getSalesTaxs(receipt.getItems()));
        // System.out.println(" Total : " +
        // receiptService.getTotalTaxdPrice(receipt.getItems()));
    }

    public static void test2() {

        ReceiptService receiptService = ReceiptService.getInstance();

        Category category1 = new Category("food", TaxEnum.NO_TAX);
        Category category2 = new Category("other", TaxEnum.BASIC_TAX);

        // TODO print imported
        Item item1 = new Item("box of chocolates", 10.00, category1, true);
        Item item2 = new Item("bottle of perfume", 47.50, category2, true);

        Receipt receipt = new Receipt();
        receipt.addItem(List.of(item1, item2));

        receiptService.printReceiptInput(receipt);
        System.out.println("-----------------------------------");
        receiptService.printReceiptOutput(receipt);

    }

    public static void test3() {
        ReceiptService receiptService = ReceiptService.getInstance();

        Category category1 = new Category("food", TaxEnum.NO_TAX);
        Category category2 = new Category("medical products", TaxEnum.NO_TAX);
        Category category3 = new Category("other", TaxEnum.BASIC_TAX);

        Item item1 = new Item("bottle of perfume", 27.99, category3, true);
        Item item2 = new Item("bottle of perfume", 18.99, category3);
        Item item3 = new Item("packet of headache pills", 9.75, category2);
        Item item4 = new Item("box of chocolates", 11.25, category1, true);
        Item item5 = new Item("box of chocolates", 11.25, category1, true);

        Receipt receipt = new Receipt();
        receipt.addItem(List.of(item1, item2, item3, item4, item5));
        receiptService.printReceiptInput(receipt);
        System.out.println("-----------------------------------");
        receiptService.printReceiptOutput(receipt);

    }
}