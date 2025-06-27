package com.steps;

import com.pojo.Post;
import com.utils.RestUtils;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class PostSteps {

    Post post;
    Response response;

    @Given("I have a valid Post payload")
    public void i_have_a_valid_post_payload() {
        post = new Post();
        post.setUserId(1);
        post.setTitle("New Post Title");
        post.setBody("This is the body of the new post");
    }

    @When("I send a POST request to {string}")
    public void i_send_a_post_request(String endpoint) {
        response = RestUtils.postRequest(endpoint, post);
    }

    @Then("I should receive status code {int}")
    public void i_should_receive_status_code(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain the same title")
    public void the_response_should_contain_the_same_title() {
        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals(actualTitle, post.getTitle());
    }
}
