package com.dineeasy.restaurant.application.menu;

import com.dineeasy.restaurant.application.menu.dto.MenuCreateDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDetailsDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuUpdateDTO;
import com.dineeasy.restaurant.application.menu.mapper.MenuMapper;
import com.dineeasy.restaurant.domain.menu.entity.Menu;
import com.dineeasy.restaurant.domain.menu.repository.MenuRepository;
import com.dineeasy.restaurant.domain.menuitem.entity.MenuItem;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import com.dineeasy.restaurant.domain.restaurant.repository.RestaurantRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MenuApplicationService {

    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuApplicationService(MenuMapper menuMapper, MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuMapper = menuMapper;
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public MenuResponseDTO createMenu(MenuCreateDTO menuCreateDTO, Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        Menu menu = menuMapper.toEntity(menuCreateDTO);
        menu.setRestaurant(restaurant);
        if (menu.getItems() != null){
            menu.getItems()
                    .forEach(item -> item.setMenu(menu));
        }
        Menu saved = menuRepository.save(menu);
        return menuMapper.toDto(saved);
    }

    public MenuResponseDTO updateMenu(MenuUpdateDTO menuUpdateDTO, Long menuId){
        Menu existingMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalStateException("Menu with id: " + menuId + " does not exist!"));
        Set<MenuItem> existingItems = existingMenu.getItems();

        Menu updateMenu = menuMapper.toEntity(menuUpdateDTO);
        System.out.println("ELOOOOOOOOOOOOOO");
        System.out.println(updateMenu.getName());

        if (updateMenu.getName() != null){
            existingMenu.setName(updateMenu.getName());
        }

        if (updateMenu.getItems() != null){
            Map<Long, MenuItem> existingItemsMap = existingItems.stream()
                    .collect(Collectors.toMap(MenuItem::getId, Function.identity()));
            Set<MenuItem> updateItems = updateMenu.getItems();

            for (MenuItem updateItem : updateItems){
                if (updateItem.getId() != null && existingItemsMap.containsKey(updateItem.getId())){
                    MenuItem existingItem = existingItemsMap.get(updateItem.getId());
                    existingItem.setName(updateItem.getName());
                    existingItem.setPrice(updateItem.getPrice());
                }
                else if (updateItem.getId() == null){
                    existingMenu.addItem(updateItem);
                }
            }
        }
        Menu savedMenu = menuRepository.save(existingMenu);
        return menuMapper.toDto(savedMenu);
    }

    public MenuResponseDetailsDTO getMenuDetails(Long menuId){
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalStateException("Menu with id: " + menuId + " does not exist!"));
        return menuMapper.toDetailsDto(menu);
    }

    public Set<MenuResponseDTO> getAllMenus(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id: " + restaurantId + " does not exist!"));
        Collection<Menu> menus = restaurant.getMenus();
        return menus.stream()
                .map(menuMapper::toDto)
                .collect(Collectors.toSet());

    }

    public void deleteMenu(Long menuId){
        try {
            menuRepository.deleteById(menuId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalStateException("Menu with id: " + menuId + " does not exist!");
        }
    }
}
