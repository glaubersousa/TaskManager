package com.isystem.taskmanagerapi.model;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;

    private String title;

    private String description;

    private LocalDate creationDate;

    private LocalDate deliveryDate;

    private String creator;

    private String responsible;

    private String statusDisplayName;

    private Integer statusCode;

    public TaskDTO(Long id, String title, String description, LocalDate creationDate,
                   LocalDate deliveryDate, String creator, String responsible,
                   String statusDisplayName, Integer statusCode) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.deliveryDate = deliveryDate;
        this.creator = creator;
        this.responsible = responsible;
        this.statusDisplayName = statusDisplayName;
        this.statusCode = statusCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatusDisplayName() {
        return statusDisplayName;
    }

    public void setStatusDisplayName(String statusDisplayName) {
        this.statusDisplayName = statusDisplayName;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
