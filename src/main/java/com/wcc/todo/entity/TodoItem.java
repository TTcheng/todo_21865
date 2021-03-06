package com.wcc.todo.entity;

import com.wcc.base.entity.BaseEntity;

public class TodoItem extends BaseEntity {
    private static final long serialVersionUID = -9165365201733239241L;
    private Short todoItemId;

    private Short userId;

    private String todoItemTitle;

    private String todoItemContent;

    private String priority;

    public Short getTodoItemId() {
        return todoItemId;
    }

    public void setTodoItemId(Short todoItemId) {
        this.todoItemId = todoItemId;
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public String getTodoItemTitle() {
        return todoItemTitle;
    }

    public void setTodoItemTitle(String todoItemTitle) {
        this.todoItemTitle = todoItemTitle;
    }

    public String getTodoItemContent() {
        return todoItemContent;
    }

    public void setTodoItemContent(String todoItemContent) {
        this.todoItemContent = todoItemContent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}