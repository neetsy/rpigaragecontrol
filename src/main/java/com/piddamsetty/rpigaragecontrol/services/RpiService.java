package com.piddamsetty.rpigaragecontrol.services;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by praneet on 8/11/18.
 */
public class RpiService {
    final GpioController gpio = GpioFactory.getInstance();

    GpioPinDigitalOutput pin4;

    public RpiService() {
        try {
            pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
        } catch (Exception e) {
            System.out.println("Cannot create switchControl. Exception: " + e.getMessage());
        }
    }

    public void openOrCloseDoor() {
        try {
          pin4.low();
          System.out.println(System.currentTimeMillis());
          pin4.high();

        }

        catch (Exception e) {
            System.out.println("Cannot pass signal. Exception: " + e.getMessage());
        }
    }


}
