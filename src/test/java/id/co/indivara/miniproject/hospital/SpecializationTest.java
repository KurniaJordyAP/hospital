package id.co.indivara.miniproject.hospital;
import id.co.indivara.miniproject.hospital.controller.AuthenticationController;
import id.co.indivara.miniproject.hospital.controller.SpecializationController;
import id.co.indivara.miniproject.hospital.dto.request.AuthenticationRequest;
import id.co.indivara.miniproject.hospital.dto.response.AuthenticationResponse;
import id.co.indivara.miniproject.hospital.entity.Specialization;
import id.co.indivara.miniproject.hospital.mapper.MapperConvertion;
import id.co.indivara.miniproject.hospital.service.SpecializationService;
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
import org.springframework.web.server.MediaTypeNotSupportedStatusException;


import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SpecializationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthenticationController authenticationController;
    @Autowired
    private SpecializationController specializationController;
    @Autowired
    private SpecializationService specializationService;
    ResponseEntity<AuthenticationResponse> response;
    String jwt;

    @Before
    public void setUp(){
        response = authenticationController.authenticate(new AuthenticationRequest("admin","lulus"));
        jwt = Objects.requireNonNull(response.getBody().getToken());
    }

    @Test
    public void getAllSpecializationTestMock() throws Exception{
        Specialization specialization = new Specialization();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/specialization/all")
                        .header("Authorization", "Bearer " +jwt)
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].specializationId").value(1L));
    }

    @Test
    public void getSpecializationByIdTestMock() throws Exception{
        Specialization specialization= new Specialization();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/specialization/1")
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.specializationId").isNotEmpty());
    }

    @Test
    public void saveSpecializationTestMock() throws Exception{
        Specialization specialization = new Specialization();
        specialization.setSpecializationName("specialization1");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/specialization/save")
                .header("Authorization","Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(MapperConvertion.toJson(specialization))
        ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateSpecializationTestMock() throws Exception{
        Specialization specialization = new Specialization();
        specialization.setSpecializationName("specialization2");
        mockMvc.perform(MockMvcRequestBuilders
                .patch("/specialization/"+2)
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content((MapperConvertion.toJson(specialization)))
        ).andDo(result -> {
            Specialization specializations = MapperConvertion.getData(result.getResponse().getContentAsString(), Specialization.class);
            Assertions.assertNotNull(specializations);
            Assertions.assertEquals("specialization2", specializations.getSpecializationName());
        })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.specializationId").isNotEmpty());
    }

    @Test
    public void deleteSpecializationTestMock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/specialization/delete/"+2)
                        .header("Authorization", "Bearer " +jwt)
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk());
    }
}
