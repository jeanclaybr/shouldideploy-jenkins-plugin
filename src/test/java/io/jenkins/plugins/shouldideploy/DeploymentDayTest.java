package io.jenkins.plugins.shouldideploy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.sf.json.JSON;
import net.sf.json.util.JSONBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeploymentDayTest {
  
  @Test
  public void itsOkToDeployOnMondays() {
    final LocalDate monday = LocalDate.of(2023, Month.APRIL, 17);
    final boolean actual = new DeploymentDay(monday).shouldDeploy();
    Assertions.assertThat(actual).isTrue();
  }
  
  @Test
  public void itsOkToDeployOnThursdays() {
    final LocalDate monday = LocalDate.of(2023, Month.APRIL, 13);
    final boolean actual = new DeploymentDay(monday).shouldDeploy();
    Assertions.assertThat(actual).isTrue();
  }

  @Test
  public void itsOkToDeployBeforeFivePm() {
    final LocalDate monday = LocalDate.of(2023, Month.APRIL, 13);
    final LocalTime five = LocalTime.of(16, 59, 59);
    final boolean actual = new DeploymentDay(monday, five).shouldDeploy();
    Assertions.assertThat(actual).isTrue();
  }

  @Test
  public void itsNotOkToDeployAfterFivePm() {
    final LocalDate monday = LocalDate.of(2023, Month.APRIL, 13);
    final LocalTime five = LocalTime.of(17, 0);
    final boolean actual = new DeploymentDay(monday, five).shouldDeploy();
    Assertions.assertThat(actual).isFalse();
  }

  @Test
  public void itsNotOkToDeployOnFridays() {
    final LocalDate friday = LocalDate.of(2023, Month.APRIL, 14);
    final boolean actual = new DeploymentDay(friday).shouldDeploy();
    Assertions.assertThat(actual).isFalse();
  }

  @Test
  public void itsNotOkToDeployOnSaturdays() {
    final LocalDate friday = LocalDate.of(2023, Month.APRIL, 22);
    final boolean actual = new DeploymentDay(friday).shouldDeploy();
    Assertions.assertThat(actual).isFalse();
  }

  @Test
  public void itsNotOkToDeployOnSundays() {
    final LocalDate friday = LocalDate.of(2023, Month.APRIL, 23);
    final boolean actual = new DeploymentDay(friday).shouldDeploy();
    Assertions.assertThat(actual).isFalse();
  }
  
  @Test
  public void foo() {
    Reason reason = new GsonBuilder().create()
      .fromJson("{\"timezone\":\"America/Sao_Paulo\",\"date\":\"2023-04-27T09:45:16.000Z\",\"shouldideploy\":true,\"message\":\"It's a free country\"}", Reason.class);
    System.out.println(reason.message);
  }
}
