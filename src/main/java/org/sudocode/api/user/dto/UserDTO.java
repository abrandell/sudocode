package org.sudocode.api.user.dto;

import org.sudocode.api.user.domain.User;

public class UserDTO {

    private Long id;
    private String login;
    private String avatarUrl;
    private boolean hireable;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.avatarUrl = user.getAvatarUrl();
        this.hireable = user.isHireable();
    }

    public UserDTO(Long id, String login, String avatarUrl, boolean hireable) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.hireable = hireable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isHireable() {
        return hireable;
    }

    public void setHireable(boolean hireable) {
        this.hireable = hireable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (hireable != userDTO.hireable) return false;
        if (!id.equals(userDTO.id)) return false;
        if (!login.equals(userDTO.login)) return false;
        return avatarUrl.equals(userDTO.avatarUrl);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + avatarUrl.hashCode();
        result = 31 * result + (hireable ? 1 : 0);
        return result;
    }
}
