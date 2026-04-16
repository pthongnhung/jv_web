package com.example.ss8.dto;


import com.example.ss8.annotation.MultipleOfTenThousand;

public class WithdrawRequestDto {

    @MultipleOfTenThousand
    private Long withdrawAmount;

    // getters, setters
    public Long getWithdrawAmount() {
        return withdrawAmount;
    }
    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}