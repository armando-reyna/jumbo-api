package com.jumbo.api.service;

import com.jumbo.api.model.Store;
import com.jumbo.api.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

//    public List<Store> getStores() {
//        return storeRepository.findAll();
//    }

    public List<Store> getClosestStores(final int numberOfStores, final Double latitude, final Double longitude) {
        final List<Store> stores = storeRepository.findAll();
        stores.parallelStream()
                .forEach( store -> store.setDistance( calculateDistance(store, latitude, longitude) )) ;
        List<Store> sortedStores = new ArrayList<>(stores);
        sortedStores.sort(Comparator.comparing(Store::getDistance));
        return sortedStores.subList(0, numberOfStores);
    }

    private Double calculateDistance(final Store store, final Double latitude, final Double longitude) {
        return Math.hypot(longitude - store.getLongitude(), latitude - store.getLatitude());
    }

}
