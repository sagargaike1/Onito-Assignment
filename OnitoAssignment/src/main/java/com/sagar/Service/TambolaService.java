package com.sagar.Service;

import com.sagar.DAO.TambolaSetRepository;
import com.sagar.DAO.TicketRepository;
import com.sagar.Model.TambolaSetEntity;
import com.sagar.Model.TambolaTicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TambolaService {

    private final TambolaSetRepository tambolaSetRepository;
    
    

    @Autowired
    public TambolaService(TambolaSetRepository tambolaSetRepository) {
        this.tambolaSetRepository = tambolaSetRepository;
    }

    public Map<String, List<String>> generateTambolaSets(int numberOfSets) {
        for (int i = 1; i <= numberOfSets; i++) {
            TambolaSetEntity tambolaSetEntity = generateSingleTambolaSet();
            tambolaSetRepository.save(tambolaSetEntity);
        }

        // Return a placeholder response (modify as needed)
        return Collections.singletonMap("status", Collections.singletonList("Tambola sets generated and saved successfully"));
    }

    private TambolaSetEntity generateSingleTambolaSet() {
        TambolaSetEntity tambolaSetEntity = new TambolaSetEntity();
        List<TambolaTicketEntity> tickets = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            TambolaTicketEntity ticket = generateSingleTambolaTicket();
            tickets.add(ticket);
        }
        tambolaSetEntity.setTickets(tickets);
        return tambolaSetEntity;
    }

    @Autowired
    TicketRepository ticketRepository;
    
    private TambolaTicketEntity generateSingleTambolaTicket() {
        TambolaTicketEntity ticket = new TambolaTicketEntity();
        List<List<Integer>> ticketNumbers = TambolaTicketGenerator.generateTicket();
        ticket.setNumbers(ticketNumbers);
        return ticket;
    }

    public List<TambolaSetEntity> getAllTambolaSets() {
        return tambolaSetRepository.findAll();
    }

    public TambolaSetEntity getTambolaSetById(Long setId) {
        return tambolaSetRepository.findById(setId)
                .orElseThrow(() -> new RuntimeException("Tambola set not found with ID: " + setId));
    }
}
