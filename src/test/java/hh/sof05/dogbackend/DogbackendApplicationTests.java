package hh.sof05.dogbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;



import hh.sof05.dogbackend.webcontrol.IndexController;
import hh.sof05.dogbackend.webcontrol.ItemController;
import hh.sof05.dogbackend.webcontrol.ManufacturerController;
import hh.sof05.dogbackend.webcontrol.UserController;

 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class DogbackendApplicationTests {
@Autowired 
private IndexController indexController;

@Autowired
private ItemController itemController;

@Autowired
private ManufacturerController manufacturerController;

@Autowired
private UserController userController;



@Autowired
    private MockMvc mockMvc;


	@Test
	void contextLoads() {
		assertThat(indexController).isNotNull();
		assertThat(itemController).isNotNull();
		assertThat(manufacturerController).isNotNull();
		assertThat(userController).isNotNull();

	}

	@Test
	 void testIndexController() throws Exception{
 mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());
                
}

	@Test
	 void testItemController() throws Exception{
 mockMvc.perform(MockMvcRequestBuilders.get("/itemlist"))
                .andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.model().attributeExists("items"));
}
@Test
    void testManufacturerController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/manufacturerlist"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("manufacturers"));
    }

	@Test
    void testUserController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userlist"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"));
    }



}