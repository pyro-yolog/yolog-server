package com.pyro.yolog.domain.member.dto.response;

import com.pyro.yolog.domain.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class MemberRoleResponse {
    private Role role;
}
