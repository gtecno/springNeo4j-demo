package com.demo.sprinbootgneo4j.demospringbootneo4j;

/**
 * Created by DESARROLLO 13 on 18/08/2017.
 */
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface MovieRepository extends GraphRepository<Movie> {

    @Query("MATCH (m:Movie)<-[rating:RATED]-(user) WHERE id(m) = {movieId} RETURN rating")
    Iterable<Movie> getRatings(@Param("movieID") Long movieId);

    List<Movie> findByTitle(String title);
}
