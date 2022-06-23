package ru.projects.providers;

import ru.projects.entities.EntityData;

import java.util.List;

// TODO: add provider builder
public interface Provider<T extends EntityData> {
    T getById(long id);

    List<T> getAll();
}
