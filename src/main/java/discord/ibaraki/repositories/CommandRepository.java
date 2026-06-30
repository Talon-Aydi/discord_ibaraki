package discord.ibaraki.repositories;

import discord.ibaraki.records.Command;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommandRepository implements ListCrudRepository<Command, Long> {
    @Override
    public <S extends Command> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Command> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Command> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Command> findAll() {
        return List.of();
    }

    @Override
    public List<Command> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Command entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Command> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
