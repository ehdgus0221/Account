package com.example.account.dto;

import com.example.account.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AccountDto {
    private Long userId;
    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    // 특정 entity에서 특정 dto로 변환해줄때 fromEntity라는 static 메소드를 만들어서
    // 생성자(userId,accountNumber, ...)를 사용하지 않고 static 메소드 생성자를 통해 생성
    // => 가독성, 안정성 좋음
    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .userId((Long) account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
