package ru.maximenko.data.client.api;

import ru.maximenko.data.client.ApiClient;
import ru.maximenko.data.client.EncodingUtils;
import ru.maximenko.data.client.model.ApiResponse;

import ru.maximenko.data.client.model.UserEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-11T20:29:38.985340800+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
public interface DataServiceApi extends ApiClient.Api {


  /**
   * 
   * 
   * @return List&lt;UserEvent&gt;
   */
  @RequestLine("GET /events")
  @Headers({
    "Accept: application/json",
  })
  List<UserEvent> getEvents();

  /**
   * 
   * Similar to <code>getEvents</code> but it also returns the http response headers .
   * 
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /events")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<UserEvent>> getEventsWithHttpInfo();


}
