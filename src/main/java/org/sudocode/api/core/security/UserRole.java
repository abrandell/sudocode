package org.sudocode.api.core.security;

public enum UserRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    MOD("ROLE_MOD"),
    ANONYMOUS("ROLE_ANONYMOUS");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String toString() {
        return role;
    }


}
