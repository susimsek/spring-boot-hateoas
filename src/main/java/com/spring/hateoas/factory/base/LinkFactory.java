package com.spring.hateoas.factory.base;

import org.springframework.hateoas.Link;

public interface LinkFactory<T> {

    T getLinks(T t);
    Link[] getLinksForCollection();
}
