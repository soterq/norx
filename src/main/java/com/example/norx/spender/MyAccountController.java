package com.example.norx.spender;

import com.example.norx.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/spender")
@AllArgsConstructor
public class MyAccountController {
    private final AppUserRepository appUserRepository;
    private final  MyAccountService myAccountService;

    @GetMapping
    public MyAccount getMyAccount(@RequestHeader(value = "Authorization") final String authToken) {
//        Authentication authentication = context.getAuthentication();
//        myAccountService.getMyAccount(appUserRepository.getById());

        return null;
    }


}
