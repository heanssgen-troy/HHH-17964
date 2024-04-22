package dev.theanssgen.io.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "oauth_connection")
@Table(name = "oauth_connections")
@IdClass(OauthConnectionId.class)
public class OauthConnection {

	@Column(name = "access_token", columnDefinition = "bytea")
	private byte[] accessToken;

	@Column(name = "access_token_expiry")
	private Instant accessTokenExpiry;

	@Id
	@Column(name = "id")
	@JdbcType(UUIDJdbcType.class)
	private UUID primarySID;

	@Id
	@Column(name = "connection")
	private String connection;

	@Column(name = "refresh_token", columnDefinition = "bytea")
	private byte[] refreshToken;

	@Column(name = "refresh_token_expiry")
	private Instant refreshTokenExpiry;

	@Column(name = "last_refresh_time")
	private Instant lastRefreshTime;

	@ElementCollection
	private List<String> grantedScopes;

	public OauthConnection() {
	}

	public OauthConnection(UUID primarySID, String connection, List<String> grantedScopes) {
		this.primarySID = primarySID;
		this.connection = connection;
		this.grantedScopes = grantedScopes;
	}

	public UUID getPrimarySID() {
		return primarySID;
	}

	public String getConnection() {
		return connection;
	}

	public List<String> getGrantedScopes() {
		return grantedScopes;
	}
}
