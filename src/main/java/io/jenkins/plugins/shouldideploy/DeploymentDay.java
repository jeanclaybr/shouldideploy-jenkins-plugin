package io.jenkins.plugins.shouldideploy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DeploymentDay {

  private final ZonedDateTime day;

  public DeploymentDay(final ZonedDateTime someday) {
    this.day = someday;
  }

  public DeploymentDay(final LocalDate date, final LocalTime time,
    final ZoneId offset) {
    this(ZonedDateTime.of(date, time, offset));
  }

  public DeploymentDay(final LocalDate date, final LocalTime time) {
    this(date, time, ZoneOffset.systemDefault());
  }
  
  public DeploymentDay(final LocalDate date) {
    this(date, LocalTime.of(12, 0));
  }

  public boolean shouldDeploy() {
    return beforeFriday()
      && beforeFivePm();
  }

  private boolean beforeFriday() {
    return this.day.getDayOfWeek().getValue() < 5;
  }

  private boolean beforeFivePm() {
    return this.day.toLocalTime().compareTo(LocalTime.of(17, 0)) < 0;
  }
  
}
