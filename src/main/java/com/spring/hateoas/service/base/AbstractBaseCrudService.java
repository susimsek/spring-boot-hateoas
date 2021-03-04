package com.spring.hateoas.service.base;

import com.spring.hateoas.exception.ResourceNotFoundException;
import com.spring.hateoas.mapper.base.BaseMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;

import java.lang.reflect.ParameterizedType;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public abstract class AbstractBaseCrudService<R extends RepresentationModel<?>,W,T,ID> implements BaseCrudService<R,W,ID> {

    final ElasticsearchRepository<T, ID> elasticsearchRepository;
    final BaseMapper<R,W,T> baseMapper;

    @Setter(onMethod=@__({@Autowired}))
    PagedResourcesAssembler<R> pagedResourcesAssembler;

    @Override
    public PagedModel<EntityModel<R>> findAll(Pageable page) {
        Page<R> tPage = elasticsearchRepository.findAll(page).map(baseMapper::tToRWithLinks);

        return pagedResourcesAssembler.toModel(tPage);
    }

    @Override
    public R getById(ID id) {
        T t = elasticsearchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(getGenericTypeClassName(), "id", id));
        return baseMapper.tToRWithLinks(t);
    }

    @Override
    public R save(W w) {
        T t = baseMapper.wToT(w);

        t = elasticsearchRepository.save(t);

        return baseMapper.tToRWithLinks(t);
    }

    @Override
    public R update(ID id, W w) {
        T t = elasticsearchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(getGenericTypeClassName(), "id", id));
        baseMapper.wToT(w,t);
        t = elasticsearchRepository.save(t);
        return baseMapper.tToRWithLinks(t);
    }

    @Override
    public void deleteById(ID id) {
        T t = elasticsearchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(getGenericTypeClassName(), "id", id));
        elasticsearchRepository.delete(t);
    }

    private String getGenericTypeClassName() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2].getTypeName();
            Class<?> clazz = Class.forName(className);
            return clazz.getSimpleName();
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <> ");
        }
    }
}
