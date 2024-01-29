package com.risf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.risf.enumeration.TaxEnum;
import com.risf.model.Category;
import com.risf.model.Item;
import com.risf.model.Receipt;

public class ReceiptServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void singltonTest() {
        ReceiptService receiptService1 = ReceiptService.getInstance();
        ReceiptService receiptService2 = ReceiptService.getInstance();
        assertEquals(true, receiptService1 == receiptService2);
    }

    @Test
    public void printReceiptInputTest() {

        ReceiptService receiptService = ReceiptService.getInstance();

        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category);
        Item item3 = new Item("phone", 299.99, category);
        Item item4 = new Item("book", 9.99, category);
        Item item5 = new Item("book", 9.99, category);
        Item item6 = new Item("chocolat", 19.99, category);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3, item4, item5, item6));
        Receipt receipt = new Receipt(items);

        receiptService.printReceiptInput(receipt);

        assertTrue(outContent.toString().trim().contains("3 phone at 299.99"));
        assertTrue(outContent.toString().trim().contains("1 chocolat at 19.99"));
        assertTrue(outContent.toString().trim().contains("2 book at 9.99"));
    }

    @Test
    public void printReceiptOutputTest() {

        ReceiptService receiptService = ReceiptService.getInstance();

        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category);
        Item item3 = new Item("phone", 299.99, category);
        Item item4 = new Item("book", 9.99, category);
        Item item5 = new Item("book", 9.99, category);
        Item item6 = new Item("chocolat", 19.99, category);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3, item4, item5, item6));
        Receipt receipt = new Receipt(items);

        receiptService.printReceiptOutput(receipt);
        assertTrue(outContent.toString().trim().contains("1 chocolat: 21.99"));
        assertTrue(outContent.toString().trim().contains("2 book: 21.98"));
        assertTrue(outContent.toString().trim().contains("3 phone: 989.97"));
        assertTrue(outContent.toString().trim().contains("Sales Taxes: 94.0 Total: 1033.94"));
    }

    @Test
    public void printReceiptTotalByReceiptTest() {

        ReceiptService receiptService = ReceiptService.getInstance();

        Category category = new Category("other", TaxEnum.BASIC_TAX);
        Item item1 = new Item("phone", 299.99, category);
        Item item2 = new Item("phone", 299.99, category);
        Item item3 = new Item("phone", 299.99, category);
        Item item4 = new Item("book", 9.99, category);
        Item item5 = new Item("book", 9.99, category);
        Item item6 = new Item("chocolat", 19.99, category);
        List<Item> items = new ArrayList<Item>(List.of(item1, item2, item3, item4, item5, item6));
        Receipt receipt = new Receipt(items);

        receiptService.printReceiptTotal(receipt);
        assertEquals("Sales Taxes: 94.0 Total: 1033.94", outContent.toString().trim());
    }
}
