package com.wcc.todo.entity;

import com.wcc.base.entity.BaseEntity;

public class TodoItem extends BaseEntity {
    private static final long serialVersionUID = -4612615635537205840L;

    private String todo_item_id ;
    private String user_id ;
    private String todo_item_title ;
    private String todo_item_content ;
    private String priority ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTodo_item_id() {
        return todo_item_id;
    }

    public void setTodo_item_id(String todo_item_id) {
        this.todo_item_id = todo_item_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTodo_item_title() {
        return todo_item_title;
    }

    public void setTodo_item_title(String todo_item_title) {
        this.todo_item_title = todo_item_title;
    }

    public String getTodo_item_content() {
        return todo_item_content;
    }

    public void setTodo_item_content(String todo_item_content) {
        this.todo_item_content = todo_item_content;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
