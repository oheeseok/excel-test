package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String cmpType;
    private String cmpNm;
    private String svcNm;
    private String creDt; // String으로 간단하게
}
