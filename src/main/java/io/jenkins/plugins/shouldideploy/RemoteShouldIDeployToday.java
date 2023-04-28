package io.jenkins.plugins.shouldideploy;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.net.http.HttpResponse.BodyHandler;
import static java.net.http.HttpResponse.BodyHandlers;

/**
 *
 * @author jean
 */
public class RemoteShouldIDeployToday implements ShouldIDeployToday {

  private static final String URL = "https://shouldideploy.today/api";

  private final String url;

  public RemoteShouldIDeployToday(String url) {
    this.url = url;
  }

  public RemoteShouldIDeployToday() {
    this(URL);
  }

  @Override
  public Reason shouldI(String timezone, LocalDate date) {
    Reason reason;
    try {
      final HttpResponse<String> response = sendRequest(timezone, date);
      if (response.statusCode() == 200) {
        reason = fromJsonString(response);
      } else {
        reason = iDontKnow();
      }
    } catch (IOException | InterruptedException ex) {
      Logger.getLogger(RemoteShouldIDeployToday.class.getName())
        .log(Level.SEVERE, null, ex);
      reason = iDontKnow();
    }
    return reason;
  }

  private HttpResponse<String> sendRequest(String timezone, LocalDate date)
    throws InterruptedException, IOException {
    final HttpClient client = HttpClient.newBuilder()
      .connectTimeout(Duration.ofMinutes(1L))
      .build();
    final HttpRequest request = HttpRequest
      .newBuilder(requestUri(timezone, date))
      .GET()
      .build();
    final BodyHandler<String> bodyHandler = BodyHandlers.ofString();
    final HttpResponse<String> response = client.send(request, bodyHandler);
    return response;
  }

  private static Reason fromJsonString(final HttpResponse<String> response)
    throws JsonSyntaxException {
    return new GsonBuilder().create().fromJson(response.body(), Reason.class);
  }

  private static Reason iDontKnow() {
    return new Reason(
      ZoneId.systemDefault().toString(),
      ZonedDateTime.now().toString(),
      true,
      "I don't know! That's up to you!"
    );
  }

  private URI requestUri(String timezone, LocalDate date) {
    return URI.create(String.format("%s?tz=%s&date=%s", this.url, timezone, date));
  }

}
