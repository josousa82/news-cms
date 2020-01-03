package org.cmsspringfive.newscms.domain.voDtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.cmsspringfive.newscms.domain.models.Role;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Valid
public class UserRequest {
    //@NotBlank(message = "not valid")
    @ApiModelProperty(notes = "User identity was generated")
    String identity;

    //@NotBlank(message = "not valid")

    @ApiModelProperty(notes = "User name was generated")
    String name;

    @ApiModelProperty(notes = "User role ${role.name} was generated")
    Role role;
}
