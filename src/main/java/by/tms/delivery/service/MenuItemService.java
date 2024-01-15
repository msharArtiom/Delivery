package by.tms.delivery.service;

import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.exception.NotFoundException;
import by.tms.delivery.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Transactional(readOnly = true)
    public Optional<MenuItem> findByName(String name) {
        if (!menuItemRepository.findByName(name).isPresent()) {
            throw new NotFoundException("There isn't menu item by this name : " + name);
        }
        return menuItemRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Optional<MenuItem> findById(Long id) {
        if (!menuItemRepository.findById(id).isPresent()) {
            throw new NotFoundException("There isn't menu item by this id : " + id);
        }
        return menuItemRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public MenuItem updateById(MenuItem menuItem) {
        if (!menuItemRepository.findById(menuItem.getId()).isPresent()) {
            throw new NotFoundException("There isn't menu item by this id : " + menuItem.getId());
        }
        return menuItemRepository.save(findById(menuItem.getId()).orElseThrow());

    }

    public void delete(Long id) {
        menuItemRepository.deleteById(id);
    }


}
