package com.example.ss8.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddRessDto {
//    @NotNull(message = "Tên người dùng Khong đc để thiếu") không đc vì nó check mới chỉ là không đc đẻ tống thôi
    @NotBlank(message = "Tên người dùng Khong đc để thiếu")
    private String receiverName;

//    @NotNull(message = "Đia chỉ không dc thiếu")
    @NotBlank(message = "Đia chỉ không dc thiếu")
    private String detailedAddress;

    public AddRessDto(String receiverName, String detailedAddress) {
        this.receiverName = receiverName;
        this.detailedAddress = detailedAddress;
    }

    public AddRessDto() {
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}
