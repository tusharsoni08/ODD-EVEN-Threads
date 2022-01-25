package com.example.demo;

import lombok.SneakyThrows;

public class EvenTask implements Runnable {
    Integer num;
    State state;
    EvenTask(Integer num, State state) {
        this.num = num;
        this.state = state;
    }

    @SneakyThrows
    @Override
    public void run() {
        while(num <= 10) {
            synchronized (state) {
                while (state.getPrinterType() == PrinterType.ODD) {
                    state.wait();
                }
                System.out.println("EVEN: " + num);
                num += 2;
                this.state.setPrinterType(PrinterType.ODD);
                state.notify();
            }
        }

    }
}
