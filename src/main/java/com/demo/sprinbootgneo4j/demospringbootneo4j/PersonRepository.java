package com.demo.sprinbootgneo4j.demospringbootneo4j;

/**
 * Created by DESARROLLO 13 on 18/08/2017.
 */
import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);
}
