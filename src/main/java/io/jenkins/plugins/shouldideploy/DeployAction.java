/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jenkins.plugins.shouldideploy;

import hudson.model.Action;
import hudson.model.Item;
import hudson.model.Project;
import org.kohsuke.stapler.StaplerProxy;

/**
 *
 * @author jean
 */
public class DeployAction implements Action/*, StaplerProxy*/ {

  private final Project project;
  private final ShouldIDeployToday deploy;

  public DeployAction(Project project) {
    this.project = project;
    this.deploy = new RemoteShouldIDeployToday();
  }

  @Override
  public String getIconFileName() {
    return "symbol-computer-disconnected";
  }

  @Override
  public String getDisplayName() {
    return "Should I deploy today?";
  }

  @Override
  public String getUrlName() {
    return "shouldideploy";
  }

  public String getName() {
    return this.project.getName();
  }

//  public String getReason() {
//    return this.deploy.shouldI().message;
//  }

  public Reason getReason() {
    return this.deploy.shouldI();
  }

}
