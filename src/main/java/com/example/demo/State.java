package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State {
    private PrinterType printerType;

    State(PrinterType printerType) {
        this.printerType = printerType;
    }
}
