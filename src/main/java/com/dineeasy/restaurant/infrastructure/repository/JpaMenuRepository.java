package com.dineeasy.restaurant.infrastructure.repository;

import com.dineeasy.restaurant.domain.menu.entity.Menu;
import com.dineeasy.restaurant.domain.menu.repository.MenuRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMenuRepository extends JpaRepository<Menu, Long>, MenuRepository {
}
