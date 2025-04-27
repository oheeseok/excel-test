package com.example.ctrl;

import com.example.helper.ExcelGenerator;
import com.example.svc.CompanySvc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyCtrl {
    private final CompanySvc companyService;
    private final ExcelGenerator excelGenerator;

    @GetMapping("/downloadCompanyList")
    public ResponseEntity<byte[]> downloadCompanyList() throws Exception {
        var companyList = companyService.getCompanyList();
        byte[] fileContent = excelGenerator.generateCompanyExcel(companyList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.attachment().filename("Company_List.xlsx").build());

        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }
}
