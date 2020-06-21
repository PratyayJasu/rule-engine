package com.example.ruleengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "entries")
public class Controller {
    @Autowired
    private RuleEngineService ruleEngineService;

    List<Map<String, String>> rulesMap;

    public List<Map<String, String>> getRulesMap() {
        return rulesMap;
    }

    public void setRulesMap(List<Map<String, String>> rulesMap) {
        this.rulesMap = rulesMap;
    }

    @PostMapping("/getResponse")
    public ResponseBack getResponseBack(@RequestBody ResponseBack responseBack) throws Exception{
        return ruleEngineService.getResponseBack(responseBack, rulesMap);
    }
}
