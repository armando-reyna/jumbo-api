package com.jumbo.api;

import com.jumbo.api.model.Store;

import java.util.List;

public class StoreFixtureFactory {

    public static List<Store> randomStores() {
        final Store originJumbo = Store.builder()
                .addressName("Jumbo Aalst Paul en Marjon Houben")
                .latitude(51.399843)
                .longitude(5.469597)
                .build();

        final Store closestJumbo = Store.builder()
                .addressName("Jumbo Eindhoven Kastelenplein")
                .latitude(51.419103)
                .longitude(5.440903)
                .build();

        final Store jumbo3 = Store.builder()
                .addressName("Jumbo Almere-Buiten Detroitpad")
                .latitude(52.395474)
                .longitude(5.274883)
                .build();

        final Store jumbo4 = Store.builder()
                .addressName("Jumbo Amsterdam Oostelijke Handelskade")
                .latitude(52.374447)
                .longitude(4.935351)
                .build();

        final Store jumbo5 = Store.builder()
                .addressName("Jumbo Assen Kleuvenstee")
                .latitude(53.017556)
                .longitude(6.585363)
                .build();

        final Store jumbo6 = Store.builder()
                .addressName("Jumbo Oldenzaal Jumbo Kuipers")
                .latitude(52.316759)
                .longitude(6.927969)
                .build();

        return List.of(jumbo3, jumbo4, closestJumbo, jumbo5, originJumbo, jumbo6);
    }

}
