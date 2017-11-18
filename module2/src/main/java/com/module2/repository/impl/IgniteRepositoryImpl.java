package com.module2.repository.impl;

import com.module2.repository.IgniteRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CachePeekMode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.cache.Cache;
import java.io.Serializable;
import java.util.*;

/**
 * We have to include it "manually" until the following issue will be resolved:
 *    https://issues.apache.org/jira/browse/IGNITE-6879
 */
public abstract class IgniteRepositoryImpl<T, ID extends Serializable> implements IgniteRepository<T, ID> {

    @Autowired
    protected Ignite igniteInstance;

    /** Ignite Cache bound to the repository */
    protected IgniteCache<ID, T> cache = null;


    /** {@inheritDoc} */
    @Override
    public <S extends T> S save (ID key, S entity) {

        cache.put (key, entity);
        return entity;
    }


    /** {@inheritDoc} */
    @Override
    public <S extends T> Iterable<S> save (Map<ID, S> entities) {

        cache.putAll (entities);
        return entities.values();
    }


    /** {@inheritDoc} */
    @Override
    public <S extends T> S save (S entity) {
        throw new UnsupportedOperationException ("Use IgniteRepository.save(key,value) method instead.");
    }


    /** {@inheritDoc} */
    @Override
    public <S extends T> Iterable<S> saveAll (Iterable<S> entities) {
        throw new UnsupportedOperationException ("Use IgniteRepository.save(Map<keys,value>) method instead.");
    }

    /** {@inheritDoc} */
    @Override
    public Optional<T> findById (ID id) {

        return Optional.ofNullable (cache.get (id));
    }


    /** {@inheritDoc} */
    @Override
    public boolean existsById (ID id) {
        return cache.containsKey (id);
    }


    /** {@inheritDoc} */
    @Override
    public Iterable<T> findAll() {
        final Iterator<Cache.Entry<ID, T>> iter = cache.iterator();

        return new Iterable<T>() {
            @Override public Iterator<T> iterator() {
                return new Iterator<T>() {
                    @Override public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @Override public T next() {
                        return iter.next().getValue();
                    }

                    @Override public void remove() {
                        iter.remove();
                    }
                };
            }
        };
    }


    /** {@inheritDoc} */
    @Override
    public Iterable<T> findAllById (Iterable<ID> ids) {

        if (ids instanceof Set)
            return cache.getAll((Set<ID>)ids).values();

        if (ids instanceof Collection)
            return cache.getAll(new HashSet<>((Collection<ID>)ids)).values();

        TreeSet<ID> keys = new TreeSet<>();

        for (ID id : ids)
            keys.add(id);

        return cache.getAll(keys).values();
    }


    /** {@inheritDoc} */
    @Override
    public long count() {
        return cache.size (CachePeekMode.PRIMARY);
    }


    /** {@inheritDoc} */
    @Override
    public void deleteById (ID id) {
        cache.remove (id);
    }


    /** {@inheritDoc} */
    @Override
    public void delete (T entity) {
        throw new UnsupportedOperationException("Use IgniteRepository.delete(key) method instead.");
    }


    /** {@inheritDoc} */
    @Override
    public void deleteAll (Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("Use IgniteRepository.deleteAll(keys) method instead.");
    }


    /** {@inheritDoc} */
    @Override
    public void deleteAllByIds (Iterable<ID> ids) {

        if (ids instanceof Set)
            cache.removeAll((Set<ID>)ids);

        if (ids instanceof Collection)
            cache.removeAll(new HashSet<>((Collection<ID>)ids));

        TreeSet<ID> keys = new TreeSet<>();

        for (ID id : ids)
            keys.add(id);

        cache.removeAll(keys);
    }


    /** {@inheritDoc} */
    @Override
    public void deleteAll() {
        cache.clear();
    }

}
