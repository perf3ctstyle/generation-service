package com.github.click.nd.rest.base.controller;

import com.github.click.nd.rest.base.domain.Resource;
import com.github.click.nd.rest.base.exception.impl.ResourceNotFoundException;
import com.github.click.nd.rest.base.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceRepository repository;

    @GetMapping(path = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Resource> findByName(@PathVariable String name) {
        return repository.findResourcesByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Resource create(@RequestBody Resource resource) {
        return repository.save(resource);
    }

    @DeleteMapping(path = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByName(@PathVariable String name) {
        repository.deleteByName(name);
    }
}