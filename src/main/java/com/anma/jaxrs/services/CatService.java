package com.anma.jaxrs.services;

import com.anma.jaxrs.database.DataConfig;
import com.anma.jaxrs.exceptions.CatNotFoundException;
import com.anma.jaxrs.models.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CatService {

    private Map<Long, Cat> cats = DataConfig.getCats();

    public CatService() {
        cats.put(1L, new Cat(1L,"Ryzhyk", 7));
        cats.put(2L, new Cat(2L, "Pukh", 8));
    }

    public List<Cat> getAllCats() {
        return new ArrayList<Cat>(cats.values());
    }

    public Cat getCat(Long id) {
        Cat cat = cats.get(id);
        if (cat == null) {
            throw new CatNotFoundException("Cat with id " + id + " not found");
        }
        return cat;
    }

    public Cat createCat(Cat cat) {
        cat.setId(cats.size() + 1);
        cats.put(cat.getId(), cat);
        return cat;
    }

    public Cat updateCat(Cat cat) {
        if (cat.getId() <=0) throw new CatNotFoundException("Cat with such id not found");
        cats.put(cat.getId(), cat);
        return cat;
    }

    public Cat removeCat(long id) {
        return cats.remove(id);
    }

}
