package com.rsjavasolutions.kafkaconsumer.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String content;

    private Set<String> addresses;
}
