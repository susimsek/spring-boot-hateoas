package com.spring.hateoas.util;

import org.springframework.hateoas.Link;

public interface LinkUtils<T> {

    T getLinks(T t);
    Link[] getLinksForCollection();
}
