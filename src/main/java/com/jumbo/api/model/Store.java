package com.jumbo.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {

    @Id
    private String uuid;
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private Double longitude;
    private Double latitude;
    private String complexNumber;
    private String showWarningMessage;
    private String todayOpen;
    private String locationType;
    private boolean collectionPoint;
    private String sapStoreID;
    private String todayClose;
    private Double distance;

}
