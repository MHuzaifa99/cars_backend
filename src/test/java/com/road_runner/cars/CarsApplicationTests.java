package com.road_runner.cars;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.road_runner.cars.controller.CarsController;
import com.road_runner.cars.model.Cars;
import com.road_runner.cars.repository.ICars;

@AutoConfigureMockMvc
@SpringBootTest
class CarsApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Mock
	private ICars CarsRepo;

	@InjectMocks
	private CarsController CarsCon;

	private JacksonTester<Cars> jsonCars;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(CarsCon).build();
	}

	LocalDateTime d = LocalDateTime.now();

	@Test
	void addCars() throws Exception {
		Cars form = new Cars("sdfsd","dfdsfds","fdsdfsdf",2525,"dsfsdfsdffffffffffffff");

		when(CarsRepo.save(form)).thenReturn(form);

		mvc.perform(MockMvcRequestBuilders.post("/cars/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonCars.write(form).getJson()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getCars() throws Exception {
		Cars form = new Cars();
		List<Cars> formArr = new ArrayList<>();
		formArr.add(form);
		when(CarsRepo.findAll()).thenReturn(formArr);

		mvc.perform(MockMvcRequestBuilders.get("/cars/get")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getByIdCars() throws Exception {

		Cars form = new Cars();
		when(CarsRepo.findById(1L)).thenReturn(Optional.of(form));

		mvc.perform(MockMvcRequestBuilders.get("/cars/get/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
