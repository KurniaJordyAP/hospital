package id.co.indivara.miniproject.hospital;
import id.co.indivara.miniproject.hospital.controller.AuthenticationController;
import id.co.indivara.miniproject.hospital.controller.SpecializationController;
import id.co.indivara.miniproject.hospital.dto.request.AuthenticationRequest;
import id.co.indivara.miniproject.hospital.dto.response.AuthenticationResponse;
import id.co.indivara.miniproject.hospital.entity.Specialization;
import id.co.indivara.miniproject.hospital.service.SpecializationService;
import org.junit.Before;
import org.junit.Test;
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
}
