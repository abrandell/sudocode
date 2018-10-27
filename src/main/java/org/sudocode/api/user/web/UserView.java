package org.sudocode.api.user.web;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "login", "avatar_url", "hireable"})
public interface UserView {

    Long getId();
    String getLogin();
    String getAvatarUrl();
    boolean isHireable();

}
