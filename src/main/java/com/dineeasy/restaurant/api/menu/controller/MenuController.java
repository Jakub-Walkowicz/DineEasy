package com.dineeasy.restaurant.api.menu.controller;


import com.dineeasy.restaurant.application.menu.MenuApplicationService;
import com.dineeasy.restaurant.application.menu.dto.MenuCreateDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDetailsDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("restaurant/{restaurantId}/menu")
public class MenuController {

    private final MenuApplicationService menuApplicationService;

    public MenuController(MenuApplicationService menuApplicationService) {
        this.menuApplicationService = menuApplicationService;
    }
    @PostMapping
    public MenuResponseDTO createMenu(@RequestBody MenuCreateDTO menuCreateDTO, @PathVariable Long restaurantId){
        return menuApplicationService.createMenu(menuCreateDTO, restaurantId);
    }

    @PutMapping("/{menuId}")
    public MenuResponseDTO updateMenu(@RequestBody MenuUpdateDTO menuUpdateDTO, @PathVariable Long menuId){
        return menuApplicationService.updateMenu(menuUpdateDTO, menuId);
    }

    @DeleteMapping("/{menuId}/{menuItemId}")
    public ResponseEntity<Void> deleteMenuItems(@PathVariable Long menuId, @PathVariable Long menuItemId){
        return menuApplicationService.deleteMenuItem(menuId, menuItemId);
    }

    @GetMapping
    public Collection<MenuResponseDTO> getAllMenus(@PathVariable Long restaurantId){
        return menuApplicationService.getAllMenus(restaurantId);
    }

    @GetMapping("/{menuId}")
    public MenuResponseDetailsDTO getMenuDetails(@PathVariable Long menuId){
        return menuApplicationService.getMenuDetails(menuId);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId){
        try {
            menuApplicationService.deleteMenu(menuId);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e){
            return ResponseEntity.notFound().build();
        }
    }



}
