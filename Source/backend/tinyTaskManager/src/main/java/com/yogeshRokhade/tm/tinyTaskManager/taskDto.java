package com.yogeshRokhade.tm.tinyTaskManager;

public class taskDto {

    private int id;
    private String title;
    private String description;
    private String priority;
    private String status;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public taskDto(){

    }

    public taskDto(String title, String description, String status, String priority) {

        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public taskDto(int id, String title, String description, String status, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }


}
