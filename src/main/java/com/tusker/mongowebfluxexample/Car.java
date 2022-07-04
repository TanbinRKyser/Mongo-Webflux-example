package com.tusker.mongowebfluxexample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String name;
    private String manufacturer;
    private String owner;
}
