package com.exercise.publish.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageHistory {
    @Id
    private String id;
    @Field
    private Long offset;
    @Field
    private String status;
    @Field
    private String message;
}
