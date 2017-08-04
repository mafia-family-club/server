package org.overmind.mfk.server.member;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 18:10
 */
@Entity(name = "members")
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Member {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private String surname;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
