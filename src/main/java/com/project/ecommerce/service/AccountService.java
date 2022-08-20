package com.project.ecommerce.service;

import com.project.ecommerce.config.Sha256;
import com.project.ecommerce.dto.AccountDto;
import com.project.ecommerce.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;

    public int join(AccountDto memberDto) {

        memberDto.setPassword(Sha256.encrypt(memberDto.getPassword()));

        if (confirmEmail(memberDto.getEmail())) {
            return 0;
        }
        accountMapper.createMember(memberDto);
        return 1;

    }
/*

    public void login(MemberDto memberDto) {
        MemberDto data = accountMapper.checkMember(memberDto);

        if(data != null) {
            memberDto.setMemberKey(data.getMemberKey());
            memberDto.setMemberName(data.getMemberName());
            memberDto.setEmail(data.getEmail());
            memberDto.setPassword(data.getPassword());
            memberDto.setPassword("");
            memberDto.setLoginTime(data.getLoginTime());
            memberDto.setCreateTime(data.getCreateTime());
        } else {
            memberDto.setMemberKey(-1);
            memberDto.setPassword("");
        }
    }
*/

    public AccountDto searchByKey(Integer memberKey) {
        return accountMapper.selectMemberByKey(memberKey);
    }

    public AccountDto edit(AccountDto accountDto) {
        accountMapper.updateAccount(accountDto);
        return searchByKey(accountDto.getMemberKey());
    }

    public void remove(Integer memberKey) {
        accountMapper.deleteAccount(memberKey);
    }

    public List<AccountDto> search() {
        return accountMapper.selectMember();
    }

    public boolean confirmEmail(String email) {
        boolean result = true;
        int rs = accountMapper.selectEmail(email);

        if (rs == 0) {
            result = false;
        }
        return result;
    }
}
