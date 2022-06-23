package ru.projects.entities;

public interface IBaseJson<T> {
    Long getId();

    void compareWithDto(T t);
}
