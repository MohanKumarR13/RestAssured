package api.test;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");

	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("****Creating User*****");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****Creating User is displayed*****");

	}

	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("****Reading  User Info*****");

		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****Reading User info is displayed*****");


	}

	@Test(priority = 3)
	public void testUpdateUserByName() {
		//update data using payload	
		logger.info("****Updating User*****");

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****Updating User is displayed*****");

		// Check after update
		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("****Deleted User*****");

		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****Deleted User is displayed*****");


	}
}