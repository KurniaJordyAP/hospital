package id.co.indivara.miniproject.hospital;

import id.co.indivara.miniproject.hospital.controller.AddressController;
import id.co.indivara.miniproject.hospital.controller.AuthenticationController;
import id.co.indivara.miniproject.hospital.dto.request.AuthenticationRequest;
import id.co.indivara.miniproject.hospital.dto.response.AuthenticationResponse;
import id.co.indivara.miniproject.hospital.entity.Address;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import id.co.indivara.miniproject.hospital.mapper.MapperConvertion;
import id.co.indivara.miniproject.hospital.repo.AddressRepository;
import id.co.indivara.miniproject.hospital.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AddressTest {
    @Autowired
    private AddressController addressController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthenticationController authenticationController;
    ResponseEntity<AuthenticationResponse> response;
    String jwt;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;

    @Before
    public void setUp(){
        response = authenticationController.authenticate(new AuthenticationRequest("admin", "lulus"));
        jwt = Objects.requireNonNull(response.getBody()).getToken();
    }

    @Test
    public void getAllAddressTestMock() throws Exception{
        Address address = new Address();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/address/all")
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].addressId").value(1L));
    }

    @Test
    public void getAddressByIdTestMock() throws Exception {
        Address address = new Address();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/address/1")
                .header("Authorization","Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.addressId").isNotEmpty());
    }

    @Test
    public void saveAddressTestMock() throws Exception {
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("city1");
        address.setProvince("province1");
        address.setZip("zip1");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/address/save")
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(MapperConvertion.toJson(address))
        ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateAddressTestMock() throws Exception {
        Address address = addressService.findById(5L);
        address.setStreet("street2");
        address.setCity("city2");
        address.setProvince("province2");
        address.setZip("zip2");
        mockMvc.perform(MockMvcRequestBuilders
                .patch("/address/"+5)
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content((MapperConvertion.toJson(address)))
        ).andDo(result -> {
            Address addresses = MapperConvertion.getData(result.getResponse().getContentAsString(), Address.class);
            Assertions.assertNotNull(addresses);
            Assertions.assertEquals(addresses.getStreet(), address.getStreet());
        })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.addressId").isNotEmpty());
    }

    @Test
    public void deleteAddressTestMock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/address/delete/"+5)
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk());
    }
}
