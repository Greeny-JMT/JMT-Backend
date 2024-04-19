package grenny.jmt.app.member.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import grenny.jmt.app.member.domain.Member;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

    Mono<Member> findByBusinessNo(String businessNo);
}
