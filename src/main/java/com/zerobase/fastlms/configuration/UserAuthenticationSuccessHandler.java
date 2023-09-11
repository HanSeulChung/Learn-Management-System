package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.loginhistory.entity.History;
import com.zerobase.fastlms.loginhistory.service.HistoryService;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.UserUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final HistoryService historyService;
    private final MemberService memberService;

    public UserAuthenticationSuccessHandler(HistoryService historyService, MemberService memberService) {
        this.historyService = historyService;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // SpringSecurity 인증 후 로그인 객체를 가져오기 위해 작성
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;

        String userId = userDetails.getUsername();
        WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
        String userAgent = UserUtils.getUserAgent(request);
        String clientIp = UserUtils.getClientIp(request);

        // LoginDt는 JPA Auditing에서 관리
        History loginHistory = History.builder()
                .userId(userId)
                .userAgent(userAgent)
                .clientIp(clientIp)
                .loginDt(LocalDateTime.now())
                .build();

        // 히스토리 저장 작업
        historyService.saveLogOnLogin(loginHistory);
        // 회원 별 최종 로그인 날짜 업데이트 작업
        memberService.updateLastLoginDt(userId, LocalDateTime.now());

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
