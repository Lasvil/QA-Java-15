import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void sortPrice() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 3500, 15, 20);
        Ticket ticket2 = new Ticket("Берлин", "Франция", 2400, 10, 20);
        Ticket ticket3 = new Ticket("Египет", "Ростов", 12765, 01, 20);
        Ticket ticket4 = new Ticket("Владивосток", "Сан-Франциско", 7600, 11, 14);
        Ticket ticket5 = new Ticket("Симферополь", "Ростов-на-Дону", 5623, 14, 17);


        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
        Ticket[] expected = {ticket2, ticket1, ticket5, ticket4, ticket3};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortSomeNameAndPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "РНД", 3500, 15, 20);
        Ticket ticket2 = new Ticket("МСК", "МСК", 2400, 10, 20);
        Ticket ticket3 = new Ticket("МСК", "РНД", 12765, 01, 20);
        Ticket ticket4 = new Ticket("МСК", "НВР", 7600, 11, 14);
        Ticket ticket5 = new Ticket("МСК", "РНД", 5623, 14, 17);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket3};
        Ticket[] actual = aviaSouls.search("МСК", "РНД");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortNoteNameAndPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "РНД", 3500, 15, 20);
        Ticket ticket2 = new Ticket("МСК", "МСК", 2400, 10, 20);
        Ticket ticket3 = new Ticket("МСК", "РНД", 12765, 01, 20);
        Ticket ticket4 = new Ticket("МСК", "НВР", 7600, 11, 14);
        Ticket ticket5 = new Ticket("МСК", "РНД", 5623, 14, 17);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("МСК", "ВРЖ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneNameAndPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "РНД", 3500, 15, 20);
        Ticket ticket2 = new Ticket("МСК", "МСК", 2400, 10, 20);
        Ticket ticket3 = new Ticket("МСК", "РНД", 12765, 01, 20);
        Ticket ticket4 = new Ticket("МСК", "НВР", 7600, 11, 14);
        Ticket ticket5 = new Ticket("МСК", "РНД", 5623, 14, 17);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.search("МСК", "МСК");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortSomeTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "РНД", 3500, 15, 20);    //5
        Ticket ticket2 = new Ticket("МСК", "МСК", 2400, 10, 20);    //10
        Ticket ticket3 = new Ticket("МСК", "РНД", 12765, 01, 20);   //19
        Ticket ticket4 = new Ticket("МСК", "НВР", 7600, 11, 12);    //1
        Ticket ticket5 = new Ticket("МСК", "РНД", 5623, 14, 17);    //3
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket1, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("МСК", "РНД", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOmeTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "РНД", 3500, 15, 20);    //5
        Ticket ticket2 = new Ticket("МСК", "МСК", 2400, 10, 20);    //10
        Ticket ticket3 = new Ticket("МСК", "РНД", 12765, 01, 20);   //19
        Ticket ticket4 = new Ticket("МСК", "НВР", 7600, 11, 12);    //1
        Ticket ticket5 = new Ticket("МСК", "РНД", 5623, 14, 17);    //3
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("МСК", "МСК", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortNoOneTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "РНД", 3500, 15, 20);    //5
        Ticket ticket2 = new Ticket("МСК", "МСК", 2400, 10, 20);    //10
        Ticket ticket3 = new Ticket("МСК", "РНД", 12765, 01, 20);   //19
        Ticket ticket4 = new Ticket("МСК", "НВР", 7600, 11, 12);    //1
        Ticket ticket5 = new Ticket("МСК", "РНД", 5623, 14, 17);    //3
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("МСК", "ВРЖ", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
