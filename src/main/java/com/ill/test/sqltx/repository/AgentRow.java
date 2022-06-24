package com.ill.test.sqltx.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("agtAgents")
@Data
public class AgentRow {

    @Id
    @Column("agentID")
    private Integer agentId;

    @Column("divisionID")
    private int divisionId;

    @Column("corporationID")
    private int corporationId;

    @Column("locationID")
    private int locationId;

    @Column("level")
    private int level;

    @Column("agentTypeID")
    private int agentTypeId;

    @Column("isLocator")
    private boolean locator;

}
