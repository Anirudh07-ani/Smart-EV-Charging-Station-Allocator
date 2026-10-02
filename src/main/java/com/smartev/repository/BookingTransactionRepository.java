package com.smartev.repository;

import com.smartev.model.BookingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingTransactionRepository extends JpaRepository<BookingTransaction, Long> {
    List<BookingTransaction> findByUser_UserId(Long userId);
    List<BookingTransaction> findByStation_StationId(Long stationId);
    List<BookingTransaction> findByStatus(String status);
    int countByStatus(String status);
}
