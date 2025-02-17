package com.example.search.document;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@ToString
@Document(indexName = "tickets")
public class Ticket {

    @Id
    @Field(type = FieldType.Text, name = "ticket_no")
    private String ticketNo;

    @Field(type = FieldType.Text, name = "book_ref")
    private String bookRef;

    @Field(type = FieldType.Text, name = "passenger_id")
    private String passengerId;

    @Field(type = FieldType.Text, name = "passenger_name")
    private String passengerName;

    @JsonRawValue
    @Field(type = FieldType.Text, name = "contact_data")
    private String contactData;
}
