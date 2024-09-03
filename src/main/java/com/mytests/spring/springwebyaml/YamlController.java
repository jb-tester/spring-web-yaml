package com.mytests.spring.springwebyaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class YamlController {

    @GetMapping(path ="/test1", produces = "application/yaml")
    public MyWebData test1() {
        return new MyWebData("aaa", List.of("bbb", "ccc"), new MyWebData.Nested("ddd"));
    }



    @PostMapping(value = "/test2", consumes = {"application/yaml", "application/yml"})
    public String test2(@RequestBody MyWebData data)  {

        return data.toString();
    }

    @PostMapping("/test3")
    public ResponseEntity<String> test3(@RequestBody MyWebData data) {
        return ResponseEntity.ok(data.toString());
    }
}
class MyWebData{

    String propOne;
    List<String> propTwo;
    Nested nested;

    public MyWebData(String propOne, List<String> propTwo, Nested nested) {
        this.propOne = propOne;
        this.propTwo = propTwo;
        this.nested = nested;
    }

    public String getPropOne() {
        return propOne;
    }

    public void setPropOne(String propOne) {
        this.propOne = propOne;
    }

    public List<String> getPropsTwo() {
        return propTwo;
    }

    public void setPropsTwo(List<String> propsTwo) {
        this.propTwo = propsTwo;
    }

    public Nested getNested() {
        return nested;
    }

    public void setNested(Nested nested) {
        this.nested = nested;
    }

    static class Nested{
        String propThree;

        public Nested(@JsonProperty("propThree")String propThree) {
            this.propThree = propThree;
        }

        public String getPropThree() {
            return propThree;
        }

        public void setPropThree(String propThree) {
            this.propThree = propThree;
        }
    }

    @Override
    public String toString() {
        return "MyWebData{" +
               "propOne='" + propOne + '\'' +
               ", propTwo=" + propTwo +
               ", nested=" + nested.getPropThree() +
               '}';
    }
}