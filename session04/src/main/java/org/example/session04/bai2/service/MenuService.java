package org.example.session04.bai2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private MenuRepository menuRepository;
    @Autowired

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public String getMenuByCategory(String category){
        return  menuRepository.getMenuByCategory(category);
    }
}
