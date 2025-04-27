package com.example.helper;

import com.example.domain.Company;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelGenerator {
    public byte[] generateCompanyExcel(List<Company> companyList) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Company List");

        // 헤더 작성
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("구분");
        headerRow.createCell(1).setCellValue("회사명");
        headerRow.createCell(2).setCellValue("서비스명");
        headerRow.createCell(3).setCellValue("등록일자");

        // 데이터 작성
        for (int i = 0; i < companyList.size(); i++) {
            Company c = companyList.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(c.getCmpType());
            row.createCell(1).setCellValue(c.getCmpNm());
            row.createCell(2).setCellValue(c.getSvcNm());
            row.createCell(3).setCellValue(c.getCreDt());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }
}
