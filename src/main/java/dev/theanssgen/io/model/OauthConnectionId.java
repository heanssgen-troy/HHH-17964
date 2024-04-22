package dev.theanssgen.io.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class OauthConnectionId {
	
	@Id
	@Column(name = "id")
	@JdbcType(UUIDJdbcType.class)
	private UUID primarySID;

	@Id
	@Column(name = "connection")
	private String connection;

	public OauthConnectionId() {
	}

	public OauthConnectionId(UUID primarySID, String connection) {
		this.primarySID = primarySID;
		this.connection = connection;
	}
}
