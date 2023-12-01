package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseBody
public class ResponseBodyController {
  @GetMapping("/response-body-string-v1")
  public void resopnseBodyV1(HttpServletResponse response) throws IOException {
    response.getWriter().write("ok");
  }

  @GetMapping("/response-body-string-v2")
  public ResponseEntity<String> resopnseBodyV2() {
    return new ResponseEntity<>("ok", HttpStatus.OK);
  }
//  @ResponseBody
  @GetMapping("/response-body-string-v3")
  public String resopnseBodyV3() {
    return "ok";
  }

  @GetMapping("/response-body-json-v1")
  public ResponseEntity<HelloData> responseBodyJsonV1() {
    HelloData helloData = new HelloData();
    helloData.setAge(20);
    helloData.setUsername("kim");
    return new ResponseEntity<>(helloData, HttpStatus.OK);
  }
  @ResponseStatus(HttpStatus.OK)
//  @ResponseBody
  @GetMapping("/response-body-json-v2")
  public HelloData responseBodyJsonV2() {
    HelloData helloData = new HelloData();
    helloData.setAge(20);
    helloData.setUsername("kim");
    return helloData;
  }
}
