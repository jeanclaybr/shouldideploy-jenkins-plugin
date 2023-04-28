package io.jenkins.plugins.shouldideploy;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author jean
 */
public interface ShouldIDeployToday {
  
  default Reason shouldI() {
    return this.shouldI(ZoneId.systemDefault().toString(), LocalDate.now());
  }
  
  Reason shouldI(String timezone, LocalDate date);
}
