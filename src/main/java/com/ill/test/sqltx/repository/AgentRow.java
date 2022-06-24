package com.ill.test.sqltx.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "agtAgents")
@Entity
@Data
public class AgentRow {

    @Id
    @Column(name = "agentID")
    private Integer agentId;

    @Column(name = "divisionID")
    private int divisionId;

    @Column(name = "corporationID")
    private int corporationId;

    @Column(name = "locationID")
    private int locationId;

    @Column(name = "level")
    private int level;

    @Column(name = "agentTypeID")
    private int agentTypeId;

    @Column(name = "isLocator")
    private boolean locator;

}
