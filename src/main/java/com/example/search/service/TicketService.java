package com.example.search.service;

import com.example.search.document.Ticket;
import com.example.search.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final ElasticsearchOperations elasticsearchOperations;
    private final TicketRepository ticketRepository;

    public List<Ticket> findByPassengerName(String passengerName, Pageable pageable) {
        NativeQuery query = NativeQuery.builder()
            .withQuery(q -> q
                .fuzzy(fq -> fq
                    .field("passenger_name")
                    .fuzziness("2")
                    .value(passengerName)
                )
            )
            .withPageable(pageable)
            .build();

        return elasticsearchOperations.search(query, Ticket.class).stream()
            .map(SearchHit::getContent)
            .toList();
    }

    public Long count() {
        return ticketRepository.count();
    }
}
