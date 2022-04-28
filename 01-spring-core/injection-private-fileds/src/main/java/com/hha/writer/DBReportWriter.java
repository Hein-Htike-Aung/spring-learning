package com.hha.writer;

import com.hha.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class DBReportWriter implements ReportWriter{

    @Override
    public void write(Report report, String reportName) {
        System.out.println(report.getClass().getSimpleName() + " " + reportName);
    }
}
