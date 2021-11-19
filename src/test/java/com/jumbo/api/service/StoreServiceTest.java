package com.jumbo.api.service;

import com.jumbo.api.StoreFixtureFactory;
import com.jumbo.api.model.Store;
import com.jumbo.api.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;

    @Test
    public void getClosestStores_simplePositions() {

        final List<Store> stores = List.of(
                Store.builder()
                        .latitude(12.0)
                        .longitude(12.0)
                        .build(),
                Store.builder()
                        .latitude(2.0)
                        .longitude(2.0)
                        .build(),
                Store.builder()
                        .latitude(10.0)
                        .longitude(10.0)
                        .build(),
                Store.builder()
                        .latitude(4.0)
                        .longitude(4.0)
                        .build(),
                Store.builder()
                        .latitude(8.0)
                        .longitude(8.0)
                        .build(),
                Store.builder()
                        .latitude(6.0)
                        .longitude(6.0)
                        .build());
        when(storeRepository.findAll()).thenReturn(stores);

        final int numberOfStores = 5;

        final List<Store> storeResult = storeService.getClosestStores(numberOfStores, 1.0, 1.0);

        assertNotNull(storeResult);
        assertEquals(numberOfStores, storeResult.size());
        assertEquals(2.0, storeResult.get(0).getLatitude());
        assertEquals(2.0, storeResult.get(0).getLongitude());
        assertEquals(4.0, storeResult.get(1).getLatitude());
        assertEquals(4.0, storeResult.get(1).getLongitude());
        assertEquals(6.0, storeResult.get(2).getLatitude());
        assertEquals(6.0, storeResult.get(2).getLongitude());
        assertEquals(8.0, storeResult.get(3).getLatitude());
        assertEquals(8.0, storeResult.get(3).getLongitude());
        assertEquals(10.0, storeResult.get(4).getLatitude());
        assertEquals(10.0, storeResult.get(4).getLongitude());

    }

    @Test
    public void getClosestStores_complexPositions() {

        final List<Store> stores = StoreFixtureFactory.randomStores();

        when(storeRepository.findAll()).thenReturn(stores);

        final int numberOfStores = 5;

        final int originJumboIndex = 4;
        final int closestJumboIndex = 2;

        //Being in Jumbo Aalst Paul en Marjon Houben
        final List<Store> storeResult = storeService.getClosestStores(numberOfStores, stores.get(originJumboIndex).getLatitude(), stores.get(originJumboIndex).getLongitude());

        assertNotNull(storeResult);
        assertEquals(numberOfStores, storeResult.size());
        assertEquals(stores.get(originJumboIndex), storeResult.get(0));
        assertEquals(stores.get(closestJumboIndex), storeResult.get(1));
        assertEquals(stores.get(0), storeResult.get(2));
        assertEquals(stores.get(1), storeResult.get(3));
        assertEquals(stores.get(5), storeResult.get(4));

    }

}
