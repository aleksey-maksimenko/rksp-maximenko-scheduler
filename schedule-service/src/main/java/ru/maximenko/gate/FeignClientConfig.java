package ru.maximenko.gate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.maximenko.data.client.ApiClient;
import ru.maximenko.data.client.api.DataServiceApi;  // бывший ReaderServiceApi
import ru.maximenko.report.client.api.ReportServiceApi;  // бывший WriterServiceApi

@Configuration
public class FeignClientConfig {

    @Bean
    public DataServiceApi readerServiceApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8905"); // data-service
        return apiClient.buildClient(DataServiceApi.class);
    }

    @Bean
    public ReportServiceApi writerServiceApi() {
        ru.maximenko.report.client.ApiClient apiClient = new ru.maximenko.report.client.ApiClient();
        apiClient.setBasePath("http://localhost:8906"); // report-service
        return apiClient.buildClient(ReportServiceApi.class);
    }
}



