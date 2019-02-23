/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static hello.DataPopulator.randomAdjective;
import static hello.DataPopulator.randomName;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
//
//	@Autowired
//	private PersonRepository personRepository;
//
//	@Before
//	public void deleteAllBeforeTests() throws Exception {
//		this.personRepository.deleteAll();
//	}
//
//	@Test
//	public void shouldReturnRepositoryIndex() throws Exception {
//
//		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
//				jsonPath("$._links.people").exists());
//	}
//
//	@Test
//	public void shouldCreateEntity() throws Exception {
//
//		this.mockMvc.perform(post("/people").content(
//				"{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isCreated()).andExpect(
//								header().string("Location", containsString("people/")));
//	}
//
//	@Test
//	public void shouldRetrieveEntity() throws Exception {
//
//		MvcResult mvcResult = this.mockMvc.perform(post("/people").content(
//				"{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isCreated()).andReturn();
//
//		String location = mvcResult.getResponse().getHeader("Location");
//		this.mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
//				jsonPath("$.firstName").value("Frodo")).andExpect(
//						jsonPath("$.lastName").value("Baggins"));
//	}
//
//	@Test
//	public void shouldQueryEntity() throws Exception {
//
//		this.mockMvc.perform(post("/people").content(
//				"{ \"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isCreated());
//
//		this.mockMvc.perform(
//				get("/people/search/findByLastName?name={name}", "Baggins")).andExpect(
//						status().isOk()).andExpect(
//								jsonPath("$._embedded.people[0].firstName").value(
//										"Frodo"));
//	}
//
//	@Test
//	public void shouldUpdateEntity() throws Exception {
//
//		MvcResult mvcResult = this.mockMvc.perform(post("/people").content(
//				"{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isCreated()).andReturn();
//
//		String location = mvcResult.getResponse().getHeader("Location");
//
//		this.mockMvc.perform(put(location).content(
//				"{\"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isNoContent());
//
//		this.mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
//				jsonPath("$.firstName").value("Bilbo")).andExpect(
//						jsonPath("$.lastName").value("Baggins"));
//	}
//
//	@Test
//	public void shouldPartiallyUpdateEntity() throws Exception {
//
//		MvcResult mvcResult = this.mockMvc.perform(post("/people").content(
//				"{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isCreated()).andReturn();
//
//		String location = mvcResult.getResponse().getHeader("Location");
//
//		this.mockMvc.perform(
//				patch(location).content("{\"firstName\": \"Bilbo Jr.\"}")).andExpect(
//						status().isNoContent());
//
//		this.mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
//				jsonPath("$.firstName").value("Bilbo Jr.")).andExpect(
//						jsonPath("$.lastName").value("Baggins"));
//	}
//
//	@Test
//	public void shouldDeleteEntity() throws Exception {
//
//		MvcResult mvcResult = this.mockMvc.perform(post("/people").content(
//				"{ \"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}")).andExpect(
//						status().isCreated()).andReturn();
//
//
//		String location = mvcResult.getResponse().getHeader("Location");
//		this.mockMvc.perform(delete(location)).andExpect(status().isNoContent());
//
//		this.mockMvc.perform(get(location)).andExpect(status().isNotFound());
//	}

	@Test
    @Ignore
	public void populatesDatabase(){
		IntStream.range(0, 2000)
				.forEach(j -> {
					String name = randomName();
					String adjective = randomAdjective();
					String document =
							"{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}"
							.replace("Frodo", adjective)
							.replace("Baggins", name);

					try {
						this.mockMvc.perform(post("/people").content(
								document)).andExpect(
								status().isCreated());
					} catch (Exception e) {
						throw new RuntimeException(e);
					}

				});


	}
}