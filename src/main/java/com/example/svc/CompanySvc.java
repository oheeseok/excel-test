package com.example.svc;

import com.example.domain.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanySvc {
    // 임시 하드코딩 데이터
    public List<Company> getCompanyList() {
        // 임시 하드코딩 데이터
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("고객사", "삼성전자", "갤럭시", "2024-01-01"));
        companies.add(new Company("제조사", "LG전자", "그램", "2024-02-15"));
        companies.add(new Company("고객사", "네이버", "클라우드", "2024-03-20"));
        return companies;
    }
}
