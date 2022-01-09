package org.acme.exposition.member.response;

import java.util.List;

public final class MembersResponse {

    public List<MemberResponse> members;

    public MembersResponse(List<MemberResponse> members) {
        this.members = members;
    }
}
