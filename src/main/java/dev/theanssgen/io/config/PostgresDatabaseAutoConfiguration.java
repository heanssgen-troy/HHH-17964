package dev.theanssgen.io.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile ("!standalone")
public class PostgresDatabaseAutoConfiguration {

	@Autowired
	private PostgresDatabaseConfig databaseConfig;

	@Bean
	public DataSource dataSource () throws SQLException
	{
		PGSimpleDataSource dataSource = new PGSimpleDataSource();

		dataSource.setDatabaseName(this.databaseConfig.getDatabaseName());
		dataSource.setUser(this.databaseConfig.getUsername());
		dataSource.setPassword(this.databaseConfig.getPassword());
		dataSource.setServerNames(new String[] {
				this.databaseConfig.getAddress()
		});
		dataSource.setPortNumbers(new int[] {
				this.databaseConfig.port
		});

		return dataSource;
	}
}
