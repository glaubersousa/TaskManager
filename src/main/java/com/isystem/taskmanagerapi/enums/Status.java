package com.isystem.taskmanagerapi.enums;

public enum Status {

    PENDING (0, "Pending"),
    IN_PROGRESS (1 ,"In progress"),
    COMPLETED (2, "Completed");

    private final Integer code;
    private final String displayName;

    Status(Integer code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public Integer getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Status fromCode(Integer code) {
        for (Status status : Status.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    public static Status fromDisplayName(String displayName) {
        for (Status status : Status.values()) {
            if (status.getDisplayName().equals(displayName)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid status display name: " + displayName);
    }

}

