package com.example.demo;

import lombok.SneakyThrows;

public class OddTask implements Runnable {
    Integer num;
    State state;
    OddTask(Integer num, State state) {
        this.num = num;
        this.state = state;
    }

    @SneakyThrows
    @Override
    public void run() {
        while(num <= 10) {
            synchronized (state) {
                while (state.getPrinterType() == PrinterType.EVEN) {
                    state.wait();
                }
                System.out.println("ODD: " + num);
                num += 2;
                this.state.setPrinterType(PrinterType.EVEN);
                state.notify();
            }
        }

    }
}
