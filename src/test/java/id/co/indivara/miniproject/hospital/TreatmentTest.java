package id.co.indivara.miniproject.hospital;

import id.co.indivara.miniproject.hospital.controller.AuthenticationController;
import id.co.indivara.miniproject.hospital.controller.TreatmentController;
import id.co.indivara.miniproject.hospital.dto.request.AuthenticationRequest;
import id.co.indivara.miniproject.hospital.dto.response.AuthenticationResponse;
import id.co.indivara.miniproject.hospital.dto.response.ResponseTreatmentList;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import id.co.indivara.miniproject.hospital.mapper.MapperConvertion;
import id.co.indivara.miniproject.hospital.repo.TreatmentRepository;
import id.co.indivara.miniproject.hospital.service.TreatmentService;

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

import java.util.List;
import java.util.Objects;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TreatmentTest {
    @Autowired
    private TreatmentController treatmentController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthenticationController authenticationController;
    ResponseEntity<AuthenticationResponse> response;
    String jwt;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private TreatmentService treatmentService;

    @Before
    public void setUp(){
       response = authenticationController.authenticate(new AuthenticationRequest("admin","lulus"));
        jwt = Objects.requireNonNull(response.getBody()).getToken();
    }

    @Test
    public void getAllTreatmentTestMock() throws Exception {
        Treatment treatment = new Treatment();
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/treatment/all")
                            .header("Authorization", "Bearer " +jwt)
                    .accept(MediaType.APPLICATION_JSON)
            ).andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].treatment_id").value(1L))
            ;

    }

    @Test
    public void getTreatmentByIdTestMock() throws Exception{
        Treatment treatment = new Treatment();
            mockMvc.perform(MockMvcRequestBuilders
                   .get("/treatment/1")
                           .header("Authorization", "Bearer " +jwt)
                   .accept(MediaType.APPLICATION_JSON)
            ).andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                   .andExpect(MockMvcResultMatchers.jsonPath("$.treatmentId").isNotEmpty());
    }

    @Test
    public void saveTreatmentTestMock() throws Exception{
        Treatment treatment = new Treatment();
        treatment.setTreatmentCode("T001");
        treatment.setTreatmentName("Test Name");
        treatment.setDescription("Test Description");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/treatment/save")
                .header("Authorization","Bearer "+jwt)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(MapperConvertion.toJson(treatment))
        ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateTreatmentTestMock() throws Exception{
        Treatment treatment = treatmentService.findById(4L);
        treatment.setTreatmentCode("T002");
        treatment.setTreatmentName("Test Name2");
        treatment.setDescription("Test Description2");
        mockMvc.perform(MockMvcRequestBuilders
               .patch("/treatment/"+4)
               .header("Authorization","Bearer "+jwt)
               .accept(MediaType.APPLICATION_JSON)
               .contentType(MediaType.APPLICATION_JSON)
                .content(MapperConvertion.toJson(treatment))
        ).andDo(result -> {
            Treatment treatments = MapperConvertion.getData(result.getResponse().getContentAsString(), Treatment.class);
            Assertions.assertNotNull(treatments);
            Assertions.assertEquals(treatments.getTreatmentName(),treatment.getTreatmentName());
        })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.treatmentId").isNotEmpty());
    }

    @Test
    public void deleteTreatmentTestMock() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/treatment/delete/"+4)
                .header("Authorization", "Bearer " +jwt)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk());
    }
}
