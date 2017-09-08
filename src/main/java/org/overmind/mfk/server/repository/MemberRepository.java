package org.overmind.mfk.server.repository;

import org.overmind.mfk.server.entry.Member;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 18:21
 */
public interface MemberRepository extends Repository<Member, Long> {

    List<Member> findAll();

    Optional<Member> findOne(Long id);

    Member save(Member member);

}
