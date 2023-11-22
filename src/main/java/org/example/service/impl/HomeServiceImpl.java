package org.example.service.impl;

import org.example.dto.Home;
import org.example.dto.HomeSimple;
import org.example.dto.Pet;
import org.example.dto.request.HomeRequest;
import org.example.dto.request.PetRequest;
import org.example.jpa.entity.HomeTab;
import org.example.jpa.entity.PetTab;
import org.example.jpa.repository.HomeRepository;
import org.example.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository){
        this.homeRepository = homeRepository;
    }

    @Override
    public Home createHome(HomeRequest homeRequest) {
        HomeTab homeTab = new HomeTab();
        this.save(homeTab, homeRequest);
        return Home.get(homeTab);
    }

    public Home editHome(Integer id, HomeRequest homeRequest) {
        HomeTab homeTab = homeRepository.findById(id).orElse(null);
        assert homeTab != null;
        this.save(homeTab, homeRequest);
        return Home.get(homeTab);
    }

    @Override
    public List<Home> getList() {
        List<HomeTab> homeTabs = homeRepository.findAll();
        List<Home> homes = new ArrayList<>();
        for (HomeTab homeTab : homeTabs) {
            Home home = Home.get(homeTab);
            homes.add(home);
        }
        return homes;
    }

    @Override
    public Home getHome(Integer id) {
        HomeTab homeTab = homeRepository.findById(id).orElse(null);
        assert homeTab != null;
        return Home.get(homeTab);
    }

    @Override
    public void destroyHome(Integer id) {
        HomeTab homeTab = homeRepository.findById(id).orElse(null);
        assert homeTab != null;
        homeRepository.delete(homeTab);
    }

    private void save(HomeTab homeTab, HomeRequest homeRequest) {
        homeTab.setName(homeRequest.getName());
        homeTab.setAddress(homeRequest.getAddress());
        homeRepository.save(homeTab);
    }
}
