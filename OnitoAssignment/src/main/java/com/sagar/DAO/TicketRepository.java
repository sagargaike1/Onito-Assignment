package com.sagar.DAO;

import com.sagar.Model.TambolaSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TambolaSetEntity , Long> {
}
