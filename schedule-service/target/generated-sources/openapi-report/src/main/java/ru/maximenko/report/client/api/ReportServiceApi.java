package ru.maximenko.report.client.api;

import ru.maximenko.report.client.ApiClient;
import ru.maximenko.report.client.EncodingUtils;
import ru.maximenko.report.client.model.ApiResponse;

import ru.maximenko.report.client.model.UserEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-11T20:29:41.333389400+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
public interface ReportServiceApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param userEvent  (required)
   */
  @RequestLine("POST /events")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void writeEvents(List<UserEvent> userEvent);

  /**
   * 
   * Similar to <code>writeEvents</code> but it also returns the http response headers .
   * 
   * @param userEvent  (required)
   */
  @RequestLine("POST /events")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> writeEventsWithHttpInfo(List<UserEvent> userEvent);


}
