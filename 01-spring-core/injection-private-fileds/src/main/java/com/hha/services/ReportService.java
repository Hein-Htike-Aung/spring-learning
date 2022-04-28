package com.hha.services;

import com.hha.ds.Report;
import com.hha.writer.ReportWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportService {

    @Value("${report.global.name}")
    private String reportGlobalName;

    @Autowired
    private ReportWriter reportWriter;

    public void execute() {
        Report report = new Report();

        reportWriter.write(report, reportGlobalName);
    }
}
