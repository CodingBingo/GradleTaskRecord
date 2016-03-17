package com.codingbingo.control

import com.codingbingo.control.bean.TaskInfo
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState
import org.gradle.util.Clock

/**
 * Created by bingo on 16/3/17.
 */
class TimeRecorder implements TaskExecutionListener, BuildListener{

    private Clock clock;
    private List<TaskInfo> taskInfoList = [];
    private GradleTaskRecorder gradleTaskRecorder;
    private float sum = 0;
    private float max = 0;

    TimeRecorder(GradleTaskRecorder gradleTaskRecorder) {
        this.gradleTaskRecorder = gradleTaskRecorder
    }

    @Override
    void buildStarted(Gradle gradle) {

    }

    @Override
    void settingsEvaluated(Settings settings) {

    }

    @Override
    void projectsLoaded(Gradle gradle) {

    }

    @Override
    void projectsEvaluated(Gradle gradle) {

    }

    @Override
    void buildFinished(BuildResult result) {
        def maxPercent = (max * 1.0 / sum * 100).toDouble().round();

        for (TaskInfo taskInfo : taskInfoList){
            def percent = (taskInfo.time * 1.0 / sum * 100).toDouble().round();
            def outStr = outBar(maxPercent, percent)

            def finalStr = "$outStr $taskInfo.path ($taskInfo.time ms)"

            if (taskInfo.isSuccess == true){
                finalStr = finalStr + " " + '\033[32m' + "[ Success ]" + '\033[0m'
            }else{
                finalStr = finalStr + " " + '\033[31m' + "[ Failure ]" + '\033[0m'
            }

            if (percent == maxPercent || percent >= 30){
                finalStr = '\033[40;31m'+ finalStr + '\033[0m'
            }
            println finalStr
        }
    }

    @Override
    void beforeExecute(Task task) {
        clock = new Clock();
    }

    @Override
    void afterExecute(Task task, TaskState state) {

        def time = clock.getTimeInMs()

        taskInfoList << new TaskInfo(
                time,
            task.path,
            state.getSkipped(),
            state.getFailure() == null
        )

        if (max < time){
            max = time
        }

        sum += time
    }

    def static final UNICODE_SQUARE = "▇";
    def static final NULL = " ";

    String outBar(def max, def value){
        def oo = value;
        if (value < 10){
            oo = NULL * 2 + oo;
        }else if(value < 100){
            oo = NULL + oo;
        }

        def outValue = NULL * (max - value) + UNICODE_SQUARE * value + oo + "%";
        return outValue;
    }
}
