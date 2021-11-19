package com.jumbo.api.control;

import com.jumbo.api.model.Store;
import com.jumbo.api.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://jumbo.armandoreyna.io"})
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/store", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StoreController {

    private final StoreService service;

    @GetMapping("/closest/{numberOfStores}/{latitude}/{longitude}")
    public List<Store> getClosestStores(@PathVariable int numberOfStores, @PathVariable Double latitude, @PathVariable Double longitude) {
        return service.getClosestStores(numberOfStores, latitude, longitude);
    }

}
