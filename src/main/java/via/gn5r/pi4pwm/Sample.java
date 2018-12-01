/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package via.gn5r.pi4pwm;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

/**
 *
 * @author gn5r
 */
public class Sample {
    
    private static PCA9685 pca9685;
    private static GpioController gpio;
    private static GpioPinDigitalOutput GPIO_00, GPIO_01;
    
    public static void main(String[] args) throws Exception {
        
        while (true) {
            delay(5000);
            GPIO_00.toggle();
            GPIO_01.toggle();
        }
        
    }

    /*    初期化メソッド    */
    private static void init() throws I2CFactory.UnsupportedBusNumberException, IOException {
        pca9685 = new PCA9685();
        pca9685.setPWMFreq(60);
        
        gpio = GpioFactory.getInstance();
        
        GPIO_00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "GPIO_~00", PinState.HIGH);
        
        GPIO_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "GPIO_01", PinState.LOW);
    }
    
    private static void delay(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}
