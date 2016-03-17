package com.codingbingo.control.bean

/**
 * Created by bingo on 16/3/17.
 */
class TaskInfo {

    long time;
    String path;
    boolean isSkipped;
    boolean isSuccess;

    TaskInfo(long time, String path, boolean isSkipped, boolean isSuccess) {
        this.time = time
        this.path = path
        this.isSkipped = isSkipped
        this.isSuccess = isSuccess
    }

}
