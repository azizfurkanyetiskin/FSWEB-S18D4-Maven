package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    public BurgerController(
            BurgerDao burgerDao
    ) {

        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> findAll() {

        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(
            @PathVariable Long id
    ) {

        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger save(
            @RequestBody Burger burger
    ) {

        BurgerValidation.validateForSave(
                burger
        );

        return burgerDao.save(
                burger
        );
    }

    @PutMapping
    public Burger update(
            @RequestBody Burger burger
    ) {

        BurgerValidation.validateForUpdate(
                burger
        );

        return burgerDao.update(
                burger
        );
    }

    @PutMapping("/{id}")
    public Burger updateById(
            @PathVariable Long id,
            @RequestBody Burger burger
    ) {

        burger.setId(id);

        BurgerValidation.validateForUpdate(
                burger
        );

        return burgerDao.update(
                burger
        );
    }

    @DeleteMapping("/{id}")
    public Burger remove(
            @PathVariable Long id
    ) {

        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(
            @PathVariable BreadType breadType
    ) {

        return burgerDao.findByBreadType(
                breadType
        );
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(
            @PathVariable int price
    ) {

        return burgerDao.findByPrice(
                price
        );
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(
            @PathVariable String content
    ) {

        return burgerDao.findByContent(
                content
        );
    }
}