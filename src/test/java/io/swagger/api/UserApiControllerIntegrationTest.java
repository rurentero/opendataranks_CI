package io.swagger.api;

import io.swagger.model.User;
import io.swagger.model.Weight;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiControllerIntegrationTest {

    @Autowired
    private UserApi api;

//    @Test
//    public void addWeightTest() throws Exception {
//        String username = "username_example";
//        Weight body = new Weight();
//        ResponseEntity<Void> responseEntity = api.addWeight(username, body);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
//    }

    @Test
    public void deleteWeightByIdTest() throws Exception {
        String username = "username_example";
        Integer weightId = 56;
        ResponseEntity<Void> responseEntity = api.deleteWeightById(username, weightId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllWeightsTest() throws Exception {
        String username = "username_example";
        ResponseEntity<List<Weight>> responseEntity = api.getAllWeights(username);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getWeightByIdTest() throws Exception {
        String username = "username_example";
        Integer weightId = 56;
        ResponseEntity<Weight> responseEntity = api.getWeightById(username, weightId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

//    @Test
//    public void loginUserTest() throws Exception {
//        String username = "username_example";
//        String password = "password_example";
//        ResponseEntity<String> responseEntity = api.loginUser(username, password);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
//    }

    @Test
    public void logoutUserTest() throws Exception {
        ResponseEntity<Void> responseEntity = api.logoutUser();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
