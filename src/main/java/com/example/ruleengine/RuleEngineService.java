package com.example.ruleengine;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
public class RuleEngineService {
    public ResponseBack getResponseBack(ResponseBack responseBack, List<Map<String, String>> ruleList) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        engine.eval("amount = " + responseBack.getAmount());
        engine.eval("pilLimit = " + responseBack.getPilLimit());
        engine.eval("flexLimit = " + responseBack.getFlexLimit());
        Predicate<Map<String, String>> predicate = (map) -> {
            boolean result = false;
            try {
                result = (Boolean) engine.eval(map.get("condition"));
            } catch (Exception e) {

            }
            return result;
        };
        Map<String, String> finalMap = ruleList.stream()
                .filter(predicate)
                .findFirst()
                .get();
        responseBack.setNextPage(finalMap.get("nextpage"));
        responseBack.setPrimary(finalMap.get("primary"));
        responseBack.setSecondary(finalMap.get("secondary"));
        return responseBack;
    }
}
