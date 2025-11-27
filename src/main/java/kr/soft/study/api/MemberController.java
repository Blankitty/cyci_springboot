package kr.soft.study.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.study.dto.BoardDTO;
import kr.soft.study.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    @GetMapping
    public void print() {

        System.out.println("first");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId("가나다");
        log.info("data: {}", memberDTO.toString());

        BoardDTO boardDTO = new BoardDTO(5, "title", "content");

        BoardDTO boardDTO1 = BoardDTO
                .builder()
                .idx(5)
                .title("제목1")
                .content("내용1")
                .build();
        log.info("boardDTO1: {}", boardDTO1.toString());
    }

    @GetMapping("/data")
    public String data() {
        return "hello World";
    }

    @GetMapping("/member")
    public MemberDTO memberDTO() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId("superman");
        memberDTO.setUserPw("1234");

        return memberDTO;
    }

    @GetMapping("/idCheck")
    public MemberDTO idCheck(HttpServletRequest request) {
        String id = request.getParameter("userId");

        //DB

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(id);

        return memberDTO;
    }
    @PostMapping("/register")
    public MemberDTO register(@RequestBody MemberDTO memberDTO) {
        log.info(memberDTO.getUserId());
        log.info(memberDTO.getUserPw());


        return  memberDTO;
    }


}
