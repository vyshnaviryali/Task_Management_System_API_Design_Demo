package com.task.demo.entity.enums;

public enum TaskStatusEnum {

    PENDING(0),
    IN_PROGRESS(1),
    COMPLETED(2);

    private int id = 0;

     TaskStatusEnum(int id){
        this.id=id;
    }

}
