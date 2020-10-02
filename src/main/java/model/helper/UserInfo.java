package model.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo extends BaseInfo {

    private String username;
    private String role;
    private String city;

}
