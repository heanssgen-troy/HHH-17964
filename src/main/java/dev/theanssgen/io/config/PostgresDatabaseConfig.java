package dev.theanssgen.io.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties ("database")
@Data
@Component
public class PostgresDatabaseConfig {

	public String address;

	public String databaseName;

	public String password;

	public int port;

	public String username;

}
