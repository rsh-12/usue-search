package com.example.search.repository;

import com.example.search.document.Ticket;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketRepository extends ElasticsearchRepository<Ticket, String> {

}
