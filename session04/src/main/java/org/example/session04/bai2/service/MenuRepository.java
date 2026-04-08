package org.example.session04.bai2.service;

import org.springframework.stereotype.Repository;

@Repository
public class MenuRepository {
    public String getMenuByCategory(String category){
        return "Menu loai: "+category;
    }
}
