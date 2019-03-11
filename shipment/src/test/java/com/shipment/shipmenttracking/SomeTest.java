package com.shipment.shipmenttracking;

import org.junit.Test;

public class SomeTest {
    @Test
    public void test() {
        try {
            Class.forName("org.postgresql.Driver");
            //on classpath
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
