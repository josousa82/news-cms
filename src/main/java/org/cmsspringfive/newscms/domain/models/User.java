package org.cmsspringfive.newscms.domain.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "system_user")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "user_id")
    String userId;

    @Column(name = "user_identity")
    String userIdentity;

    @Column(name = "user_name")
    String userName;

    @Column(name = "user_role")
    Role userRole;
}
