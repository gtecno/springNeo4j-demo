package com.demo.sprinbootgneo4j.demospringbootneo4j;

/**
 * Created by DESARROLLO 13 on 18/08/2017.
 */

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Movie {

    @GraphId Long id;

    String title;

    Person director;

    @Relationship(type="ACTED_IN", direction = Relationship.INCOMING)
    Set<Person> actors = new HashSet<>();
}