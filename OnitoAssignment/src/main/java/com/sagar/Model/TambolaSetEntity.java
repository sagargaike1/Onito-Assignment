package com.sagar.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tambola_sets")
public class TambolaSetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tambola_set_id")
    private List<TambolaTicketEntity> tickets;

    // Add any additional fields or annotations as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TambolaTicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TambolaTicketEntity> tickets) {
        this.tickets = tickets;
    }
}
