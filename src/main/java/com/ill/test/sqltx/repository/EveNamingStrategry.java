package com.ill.test.sqltx.repository;

import java.io.Serial;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class EveNamingStrategry extends PhysicalNamingStrategyStandardImpl {

    @Serial
    private static final long serialVersionUID = 7977160223392406106L;

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        String tableName = name.getText();
        return Identifier.quote(Identifier.toIdentifier(tableName));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        String columnName = name.getText();
        return Identifier.quote(Identifier.toIdentifier(columnName));
    }

}
