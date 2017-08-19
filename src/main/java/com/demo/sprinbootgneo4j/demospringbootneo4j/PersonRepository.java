package com.demo.sprinbootgneo4j.demospringbootneo4j;

/**
 * Created by DESARROLLO 13 on 18/08/2017.
 */
import org.springframework.data.neo4j.repository.GraphRepository;

public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);
}
