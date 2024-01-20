package com.sagar.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tambola_tickets")
public class TambolaTicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @OrderColumn(name = "column_index")
    private List<List<Integer>> numbers;

    // Add any additional fields or annotations as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }
}
