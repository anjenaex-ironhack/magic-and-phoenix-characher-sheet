package com.magicandphoenix.charactersheetservice.controller.dto;

import javax.validation.constraints.Min;

public class PxDTO {

    @Min(0)
    private int px = 0;

    public PxDTO() {
    }

    public PxDTO(@Min(0) int px) {
        this.px = px;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }
}
