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

  @GraphId private  Long id;

   private String title;

   private  Person director;


    @Relationship(type="ACTED_IN", direction = Relationship.INCOMING)
 private   Set<Person> actors = new HashSet<>();


    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie( String title, Person director) {
        this.title = title;
        this.director = director;
    }

    public Movie(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Person> getActors(Set<Person> actores) {
        return actors;
    }

    public void setActors(Set<Person> actors) {
        this.actors = actors;
    }
}