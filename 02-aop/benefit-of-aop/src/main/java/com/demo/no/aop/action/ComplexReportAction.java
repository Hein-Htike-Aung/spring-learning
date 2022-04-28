package com.demo.no.aop.action;

import com.demo.no.aop.bls.ComplexReportFormatter;
import com.demo.no.aop.bls.ComplexReportProvider;
import com.demo.no.aop.bls.ComplexReportRepository;
import com.demo.no.aop.ds.FormattedReport;
import com.demo.no.aop.ds.Report;
import com.demo.no.aop.logger.PerformanceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplexReportAction {

    @Autowired
    private ComplexReportProvider complexReportProvider;

    @Autowired
    private ComplexReportFormatter complexReportFormatter;

    @Autowired
    private ComplexReportRepository complexReportRepository;

    @Autowired
    private PerformanceLogger performanceLogger;

    public void preform() throws InterruptedException{

        PerformanceLogger.PerformaceLoggerInfo performaceLoggerInfo;

        performaceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        Report report = complexReportProvider.getReport();
        performanceLogger.stop(performaceLoggerInfo);

        performaceLoggerInfo = performanceLogger.start("complexReportPFormatter.formatReport()");
        FormattedReport formattedReport = complexReportFormatter.formattedReport(report);
        performanceLogger.stop(performaceLoggerInfo);

        performaceLoggerInfo = performanceLogger.start("complexReportRepository.save(report)");
        complexReportRepository.save(formattedReport);
        performanceLogger.stop(performaceLoggerInfo);


        performaceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        report = complexReportProvider.getReport();
        performanceLogger.stop(performaceLoggerInfo);
    }
}
