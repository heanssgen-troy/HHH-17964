package dev.theanssgen.io;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.theanssgen.io.model.OauthConnection;
import dev.theanssgen.io.model.OauthConnectionId;

@SpringBootTest()
public class TestHH17964 {

	@Autowired
	private OauthConnectionRepository repository;
	
	@Test
	@Transactional	
	public void testSaveOauthConnection() {
		OauthConnection connection = new OauthConnection();
		connection.setGrantedScopes(Arrays.asList("Test", "Pineapple"));
		connection.setConnection("jira");
		connection.setPrimarySID(UUID.randomUUID());
		
		OauthConnectionId id = new OauthConnectionId();
		id.setConnection("jira");
		id.setPrimarySID(connection.getPrimarySID());
		
		this.repository.save(connection);
		Optional<OauthConnection> conn = this.repository.selectByIdLocking(id);
		conn.get().setGrantedScopes(Arrays.asList("foo", "bar"));
	}
	
}
