package com.project.ecommerce.mapper;

import com.project.ecommerce.dto.AccountDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {
    void createMember(AccountDto accountDto);
    AccountDto checkMember(AccountDto accountDto);
    AccountDto selectMemberByKey(Integer memberKey);

    void updateAccount(AccountDto accountDto);

    void deleteAccount(List<Integer> memberKeyArray);

    List<AccountDto> selectMember();

    int selectEmail(String email);
}
