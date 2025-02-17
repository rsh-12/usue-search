package com.example.search.controller;

import com.example.search.document.Ticket;
import com.example.search.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/tickets/count")
    public ResponseEntity<Long> ticketsCount() {
        return ResponseEntity.ok(ticketService.count());
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> findPassengers(@RequestParam("passengerName") String passengerName, Pageable pageable) {
        if (passengerName == null || passengerName.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticketService.findByPassengerName(passengerName, pageable));
    }

}
