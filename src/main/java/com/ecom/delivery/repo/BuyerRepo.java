package com.ecom.delivery.repo;

import com.ecom.delivery.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> {
}
