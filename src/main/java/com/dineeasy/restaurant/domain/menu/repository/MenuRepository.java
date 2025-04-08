package com.dineeasy.restaurant.domain.menu.repository;

import com.dineeasy.restaurant.domain.menu.entity.Menu;
import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    Menu save(Menu menu);
    Optional<Menu> findById(Long id);
    void deleteById(Long id);
    List<Menu> findAll();
}
