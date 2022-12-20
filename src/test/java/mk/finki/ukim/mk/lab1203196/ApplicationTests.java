package mk.finki.ukim.mk.lab1203196;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import mk.finki.ukim.mk.lab1203196.service.AuthenticationService;
import mk.finki.ukim.mk.lab1203196.service.BalloonService;
import mk.finki.ukim.mk.lab1203196.service.ManufacturerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    MockMvc mvcMock;
    @Autowired
    private BalloonService balloonService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private AuthenticationService authenticationService;



    private static boolean dataInitialized = false;

    @BeforeEach
    public void setup(WebApplicationContext wac){
        this.mvcMock = MockMvcBuilders.webAppContextSetup(wac).build();
        initData();
    }
    private void initData() {
        if (!dataInitialized) {
            Manufacturer manufacturer
                    = new Manufacturer("man","man","man");

            String user = "user";
            String admin = "admin";
            LocalDate dob = LocalDate.parse("2001-11-01");

            authenticationService.register(user, user, user, user, user, dob);
            authenticationService.register(admin, admin, admin, admin, admin, dob);
            dataInitialized = true;
        }

}
    @Test
    public void testGetBalloons() throws Exception{
        MockHttpServletRequestBuilder balloonRequest =  MockMvcRequestBuilders.get("/balloons");
        this.mvcMock.perform(balloonRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("balloons"))
                .andExpect(MockMvcResultMatchers.model().attribute("bodyContent", "listBalloons"))
                .andExpect(MockMvcResultMatchers.view().name("master-template"));
    }
}
