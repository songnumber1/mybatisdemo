package com.example.mybatis.demo.mybatisdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// http://localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("/api/v1/swagger")
@Api(tags = "SwaggerController")
public class SwaggerController {

    @Operation(summary = "요약", description = "설명")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{data}")
    public String home(@Parameter(description = "파라미터 설명", example = "1") @PathVariable String data) {
    
        return "SwaggerController : " + data;
    }
}
