package org.overmind.mfk.server.entry;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Member {

    @Id
    @GenericGenerator(
        name = "member_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "members_id_seq")
        }
    )
    @GeneratedValue(generator = "member_generator")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @Column(length = 32)
    private String name;

    @NonNull
    @Column(length = 32)
    private String surname;

    @NonNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
