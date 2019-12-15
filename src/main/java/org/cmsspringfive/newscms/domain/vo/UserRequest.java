package org.cmsspringfive.newscms.domain.vo;

import lombok.Data;
import org.cmsspringfive.newscms.domain.models.Role;

@Data
public class UserRequest {

    String identity;
    String name;

    Role role;
}
