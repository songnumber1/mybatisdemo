package com.example.mybatis.demo.mybatisdemo;

import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.demo.mybatisdemo.common.ymlDefaultProperty;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// http://localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("/api/v1/swagger")
@Api(tags = "SwaggerAPIV1Controller")
public class SwaggerAPIV1Controller {
    @Value("${ymlExistDefaultData:"+ ymlDefaultProperty.ymlExistDefaultData + "}")
    private String ymlExistDefaultData;

    @Value("${ymlNoExistDefaultData:"+ ymlDefaultProperty.ymlNoExistDefaultData + "}")
    private String ymlNoExistDefaultData;

    @Operation(summary = "요약", description = "설명")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{data}")
    public String home(@Parameter(description = "파라미터 설명", example = "1") @PathVariable String data) {
    
        StringBuilder str = new StringBuilder();
        str.append("SwaggerAPIV1Controller : ").append(data).append("\n");
        str.append("ymlExistDefaultData : ").append(ymlExistDefaultData).append("\n");
        str.append("ymlNoExistDefaultData : ").append(ymlNoExistDefaultData).append("\n");

        return str.toString();
    }
}
