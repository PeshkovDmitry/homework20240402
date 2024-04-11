package ru.gb.homework20240402.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sql.statements")
@Getter
@Setter
public class SqlStatementConfiguration {

    private String findAll;

    private String save;

    private String deleteById;

    private String getOne;

    private String update;

}
