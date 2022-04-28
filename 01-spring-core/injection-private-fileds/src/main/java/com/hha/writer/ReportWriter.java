package com.hha.writer;

import com.hha.ds.Report;

public interface ReportWriter {

    void write(Report report, String reportName);
}
