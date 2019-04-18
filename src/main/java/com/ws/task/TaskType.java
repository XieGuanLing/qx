package com.ws.task;

/**
 * create by gl
 * on 2019/4/4
 */
public enum TaskType {

    ONE("第一个定时任务");



    private String name;

    private TaskType(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
