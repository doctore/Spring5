package com.module2.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Map;

/**
 * We have to include it "manually" until the following issue will be resolved:
 *    https://issues.apache.org/jira/browse/IGNITE-6879
 */
public interface IgniteRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    /**
     * Deletes the entities which IDs match with the given ones.
     *
     * @param ids Entity's key.
     */
    void deleteAllByIds (Iterable<ID> ids);

    /**
     * Saves a given entity using provided key.
     * </p>
     * It's suggested to use this method instead of default {@link CrudRepository#save(Object)} that generates
     * IDs (keys) that are not unique cluster wide.
     *
     * @param key Entity's key.
     * @param entity Entity to save.
     * @param <S> Entity type.
     * @return Saved entity.
     */
    <S extends T> S save (ID key, S entity);

    /**
     * Saves all given keys and entities combinations.
     * </p>
     * It's suggested to use this method instead of default {@link CrudRepository#save(Iterable)} that generates
     * IDs (keys) that are not unique cluster wide.
     *
     * @param entities Map of key-entities pairs to save.
     * @param <S> type of entities.
     * @return Saved entities.
     */
    <S extends T> Iterable<S> save (Map<ID, S> entities);
}
