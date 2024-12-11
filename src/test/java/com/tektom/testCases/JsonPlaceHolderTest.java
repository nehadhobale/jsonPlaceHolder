package com.tektom.testCases;


import com.jayway.jsonpath.JsonPath;
import com.tektom.utility.TestDataReader;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.List;


import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends BaseTest {
    private static Logger logger = LogManager.getLogger(JsonPlaceHolderTest.class);

    @DataProvider(name = "UserIdTestData")
    public Object[][] userIdTestData(){
        return TestDataReader.provideData("src/test/resources/testData/UserIdTestData.csv");
    }


    @Test(dataProvider = "UserIdTestData")
    public void verifyJsonPlaceHolderUsers(String userId) throws IOException {
        //Get a random user and print emailID
        Response emailResponse = given().get(usersEndpoint+userId);
        logger.info("EmailId of User "+userId+" :- "+ JsonPath.parse(emailResponse.asString()).read("$.email"));

        //Using this userID, get this user’s associated posts.
        //verify they contain valid Post IDs (an Integer between 1 and 100).
        Response postsIdResponse = given().get(postsEndpoint);
        List<Integer>  postsIdList = JsonPath.parse(postsIdResponse.asString()).read("$[?(@.userId=="+userId+")].id");
        for (Integer postsId :postsIdList) {
            Assert.assertTrue(postsId>=1 && postsId<=100 ,"Post is invalid");
        }

        //Create a post using the same userID with a non-empty title and body
        // verify the correct response is returned.
        String content = TestDataReader.getJsonData("src/test/resources/testData/CreatePostTestData.json");

        content=JsonPath.parse(content).set("$.userId",userId).jsonString();
        content=JsonPath.parse(content).set("$.title","test").jsonString();

        Response createPostsResponse =  given()
                .body(content)
                .when()
                .post("https://jsonplaceholder.org/posts");
        Assert.assertEquals(createPostsResponse.getStatusCode(),201,"Status code is not 201");

    }
}
