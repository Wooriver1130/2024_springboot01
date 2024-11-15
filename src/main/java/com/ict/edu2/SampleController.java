package com.ict.edu2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class SampleController {

    // 반환형이 String
    @GetMapping("/test01")
    public String test01() {

        return "세상아 안녕";
    }
    
    // 반환형이 String[](배열) => 자동으로 json 형식을 가지고 출력한다.
    @GetMapping("/test02") 
    public String[] test02() {

        return new String[] {"세상아", "안녕"};
    }
    
    // 반환형이 객체일떄 
    @GetMapping("/test03") 
    public SampleVO test03() {
        List<SampleVO> list = new ArrayList<>();
        SampleVO svo = new SampleVO();
        svo.setName("고길동");
        svo.setAge("24");
        
        list.add(svo);
        return svo;
    }
    // 반환형이 객체일떄 
    @GetMapping("/test04") 
    public List<SampleVO> test04() {
        List<SampleVO> list = new ArrayList<>();
        
        SampleVO svo = new SampleVO();
           svo.setName("고길동");
           svo.setAge("24");
           list.add(svo);
           
           SampleVO svo2 = new SampleVO();
           svo2.setName("희동이");
           svo2.setAge("3");
           list.add(svo2);
           
           SampleVO svo3 = new SampleVO();
           svo3.setName("도우너");
           svo3.setAge("17");
           list.add(svo3);
           
           return list;
        }
        
        // 반환형이 객체일떄 
        @GetMapping("/test05") 
        public DataVO test05(String number) {
            DataVO dataVO = new DataVO<>();

            List<SampleVO> list = new ArrayList<>();
        
                SampleVO svo = new SampleVO("고길동", "24");
                SampleVO svo2 = new SampleVO("희동이", "3");
                SampleVO svo3 = new SampleVO("마이콜", "50");
                list.add(svo);
                list.add(svo2);
                list.add(svo3);
                

            if (number.equals("1")) {
  /*               dataVO.setResultCode(1);
                dataVO.setMsg("성공");
                dataVO.setData(list); */
                return DataVO.success(list, "성공");
            }else {
/*                 dataVO.setResultCode(0);
                dataVO.setMsg("실패");
                dataVO.setData(null); */
                
                return DataVO.fail(0, "실패");
            }
        }
        @PostMapping("/hi1")
        public String sayHi1( String idx) {
            return "hi, 안녕하세요, 방가방가";
        }
        
        @PostMapping("/hi2")
        // 일반적인 파라미터는 get/post가 같다.
        public String[]  sayHi2( String idx) {
            return new String[] {"hello", "worlds"};
        }
        @PostMapping("/hi3")
        // 일반적인 파라미터는 get/post가 같다.
        public String[]  sayHi3(@RequestParam("idx") String idx) {
            return new String[] {"hello", "words"};
        }
        @PostMapping("hi4")
        // 요청 자체가 json 방식일 때 
        public String[] sayHi4(@RequestBody Map<String, String> params) {
            return new String[] {"hello", "words"};
            
        }
         // 반환형이 객체일떄 
        @PostMapping("/hi5") 
        public SampleVO sayHi5() {
            SampleVO svo = new SampleVO();
            svo.setName("고길동");
            svo.setAge("24");
            
            return svo;
    }

    // 반환형이 객체일떄 
    @PostMapping("/hi6") 
    public List<SampleVO> sayHi6() {
        List<SampleVO> list = new ArrayList<>();
        
        SampleVO svo = new SampleVO();
           svo.setName("고길동");
           svo.setAge("24");
           list.add(svo);
           
           SampleVO svo2 = new SampleVO();
           svo2.setName("희동이");
           svo2.setAge("3");
           list.add(svo2);
           
           SampleVO svo3 = new SampleVO();
           svo3.setName("도우너");
           svo3.setAge("17");
           list.add(svo3);
           
           return list;
        }

        // 반환형이 객체일떄 
        @PostMapping("/hi7") 
        public DataVO sayHi7(String number) {
            DataVO dataVO = new DataVO<>();

            List<SampleVO> list = new ArrayList<>();
        
                SampleVO svo = new SampleVO("고길동", "24");
                SampleVO svo2 = new SampleVO("희동이", "3");
                SampleVO svo3 = new SampleVO("마이콜", "50");
                list.add(svo);
                list.add(svo2);
                list.add(svo3);
                

            if (number.equals("1")) {
  /*               dataVO.setResultCode(1);
                dataVO.setMsg("성공");
                dataVO.setData(list); */
                return DataVO.success(list, "성공");
            }else {
/*                 dataVO.setResultCode(0);
                dataVO.setMsg("실패");
                dataVO.setData(null); */
                
                return DataVO.fail(0, "실패");
            }
        }
        
        
        
    }
    