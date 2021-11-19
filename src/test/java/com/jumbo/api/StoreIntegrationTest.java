package com.jumbo.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.api.model.Store;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StoreIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getClosestStores() throws Exception {

        //Given
        final String sortedStores = IOUtils.resourceToString("/sorted_stores.json", Charset.defaultCharset());
        final List<Store> expectedStores = objectMapper.readValue(sortedStores, new TypeReference<>() {
        });

        //When
        final MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/store/closest/5/51.399843/5.469597").accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        // THEN
        assertEquals(response.getStatus(), HttpStatus.OK.value());
        final List<Store> actualStores = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});

        assertEquals(5, actualStores.size());
        assertEquals(expectedStores.get(0).getUuid(), actualStores.get(0).getUuid());
        assertNotNull(actualStores.get(0).getDistance());
        assertEquals(expectedStores.get(1).getUuid(), actualStores.get(1).getUuid());
        assertNotNull(actualStores.get(1).getDistance());
        assertEquals(expectedStores.get(2).getUuid(), actualStores.get(2).getUuid());
        assertNotNull(actualStores.get(2).getDistance());
        assertEquals(expectedStores.get(3).getUuid(), actualStores.get(3).getUuid());
        assertNotNull(actualStores.get(3).getDistance());
        assertEquals(expectedStores.get(4).getUuid(), actualStores.get(4).getUuid());
        assertNotNull(actualStores.get(4).getDistance());

    }

}
