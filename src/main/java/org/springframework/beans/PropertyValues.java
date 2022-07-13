package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue currentPv = this.propertyValueList.get(i);
            if (currentPv.getName().equals(propertyValue.getName())) {
                this.propertyValueList.set(i, propertyValue);
                return;
            }
        }
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue propertyValue = this.propertyValueList.get(i);
            if (propertyName.equals(propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }
}
