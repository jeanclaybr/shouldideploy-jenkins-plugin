package io.jenkins.plugins.shouldideploy;

/**
 * 
 * <pre>
 * {
 *   "timezone": "America/Sao_Paulo",
 *   "date": "2023-04-27T09:45:16.000Z",
 *   "shouldideploy": true,
 *   "message": "It's a free country"
 * }
 * </pre>
 * @author jean
 */
public class Reason {
  public String timezone;
  public String date;
  public boolean shouldideploy;
  public String message;

  public Reason() {
    // Nothing to do.
  }

  public Reason(String timezone, String date, boolean shouldideploy, String message) {
    this.timezone = timezone;
    this.date = date;
    this.shouldideploy = shouldideploy;
    this.message = message;
  }

}
