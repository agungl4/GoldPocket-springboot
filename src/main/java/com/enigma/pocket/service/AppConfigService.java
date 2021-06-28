package com.enigma.pocket.service;

import java.util.Map;

public interface AppConfigService {

    public String getValue(String key);
    public void setValue(String key, Object value);
    public Map<String,Object> getMap(String key);

}
