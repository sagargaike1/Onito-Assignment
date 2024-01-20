package com.sagar.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TambolaTicketGenerator {

    public static List<List<Integer>> generateTicket() {
        List<List<Integer>> ticket = new ArrayList<>();

        // Create a list of numbers 1 to 90
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numbers.add(i);
        }

        // Shuffle the numbers
        Collections.shuffle(numbers);

        // Divide the numbers into columns
        for (int col = 0; col < 9; col++) {
            List<Integer> column = new ArrayList<>();
            for (int row = 0; row < 3; row++) {
                column.add(numbers.remove(0));
            }
            Collections.sort(column);
            ticket.add(column);
        }

        // Blank Cell fill by zero
        for (List<Integer> row : ticket) {
            for (int i = 0; i < 9; i++) {
                if (!row.contains(i + 1)) {
                    row.add(i, 0);
                }
            }
        }

        return ticket;
    }

    public static List<List<List<Integer>>> generateTickets(int numberOfTickets) {
        List<List<List<Integer>>> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> generatedTickets = generateTickets(6);
        for (int i = 0; i < generatedTickets.size(); i++) {
            System.out.println("Ticket " + (i + 1) + ": " + generatedTickets.get(i));
        }
    }
}
