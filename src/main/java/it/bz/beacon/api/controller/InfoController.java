package it.bz.beacon.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import it.bz.beacon.api.db.model.Info;
import it.bz.beacon.api.model.InfoCreation;
import it.bz.beacon.api.model.InfoUpdate;
import it.bz.beacon.api.service.info.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/admin/infos")
public class InfoController {

    @Autowired
    private IInfoService service;

    @ApiOperation(value = "View a list of all infos")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Info> getList() {
        return service.findAll();
    }

    @ApiOperation(value = "Search a info with an ID")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    public Info get(@PathVariable long id) {
        return service.find(id);
    }

    @ApiOperation(value = "Create a info", authorizations = {@Authorization(value = "JWT")})
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Info create(@Valid @RequestBody InfoCreation userCreation) {
        return service.create(userCreation);
    }

    @ApiOperation(value = "Update a info", authorizations = {@Authorization(value = "JWT")})
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}", produces = "application/json")
    public Info update(@PathVariable long id, @Valid @RequestBody InfoUpdate userUpdate) {
        return service.update(id, userUpdate);
    }

}