package com.codingbingo.control

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by bingo on 16/3/16.
 */
public class GradleTaskRecorder implements Plugin<Project> {

    public void apply(Project project) {
        project.gradle.addBuildListener(new TimeRecorder(this));
    }

}
