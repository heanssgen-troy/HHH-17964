package dev.theanssgen.io;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.theanssgen.io.model.OauthConnection;
import dev.theanssgen.io.model.OauthConnectionId;
import jakarta.persistence.LockModeType;

@Repository
public interface OauthConnectionRepository extends CrudRepository<OauthConnection, OauthConnectionId>, QuerydslPredicateExecutor<OauthConnection>, JpaRepository<OauthConnection, OauthConnectionId>{

	@Override
	public Optional<OauthConnection> findById (OauthConnectionId id);

	@Query (value = "SELECT oc FROM oauth_connection oc WHERE oc.id = ?1")
	@Lock (LockModeType.PESSIMISTIC_WRITE)
	public Optional<OauthConnection> selectByIdLocking (OauthConnectionId id);
}
