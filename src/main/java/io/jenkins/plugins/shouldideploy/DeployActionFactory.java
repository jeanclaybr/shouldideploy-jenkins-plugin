/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.jenkins.plugins.shouldideploy;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.Project;
import java.util.Collection;
import java.util.Collections;
import jenkins.model.TransientActionFactory;

/**
 *
 * @author jean
 */
@Extension
public class DeployActionFactory extends TransientActionFactory<Project> {
  
  @Override
  public Class<Project> type() {
    return Project.class;
  }

  @Override
  public Collection<? extends Action> createFor(Project project) {
    return Collections.singleton(new DeployAction(project));
  }

}
