package testsetup;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import testsetup.domain.Person;

import java.util.stream.IntStream;

import static testsetup.DatabasePopulationData.randomAppelation;
import static testsetup.DatabasePopulationData.randomName;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@Ignore
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void populatesDatabase() {
        IntStream.range(0, 20000)
                .forEach(j -> {
                    Person person = new Person(randomAppelation(), randomName());
                    try {
                        String document = this.objectMapper.writeValueAsString(person);
                        this.mockMvc
                                .perform(post("/person")
                                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                                        .content(document))
                                .andExpect(status().isOk());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                });


    }
}