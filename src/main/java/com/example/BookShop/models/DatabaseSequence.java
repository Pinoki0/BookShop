package com.example.BookShop.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@Getter
@Setter
public class DatabaseSequence {
    @Id
    public String id;

    public long seq;
}
