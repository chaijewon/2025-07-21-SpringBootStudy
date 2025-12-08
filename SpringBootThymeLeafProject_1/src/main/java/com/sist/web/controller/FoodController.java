package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *   1. 교재 
 *      1장 : 스프링 프레임워크 
 *           = DI , AOP (경량 컨테이너)
 *             DI : 객체 생성시에 필요한 데이터를 주입 
 *                  => 이미 생성된 객체의 주소값을 얻는 경우 
 *                  => 큰 의미 : 객체와 객체의 연관 관계 설정 
 *                  => DI의 종류 
 *                     1) setter DI : set메소드를 이용해서 변수의 초기화
 *                        <bean id="" class=""
 *                         p:name=""
 *                        />
 *                        = application.properties 
 *                        = application.yml에 등록 
 *                     2) 생성자 DI = 매개변수에 값을 첨부  
 *                        <bean id="" class=""
 *                        c:name=""
 *                        />
 *                     3) method DI 
 *                        = 객체 생성시에 자동 호출 
 *                        = 객체 소멸시에 자동 호출 
 *                        <bean id="" class=""
 *                         init-method="init"
 *                         destory-method="destory">
 *                     4) 객체 주소값 주입 : 스프링에서 생성된 객체 
 *                        @Autowired => 스프링에서 자동으로 객체를 찾아서
 *                                      주소값 대입 
 *                        A a;
 *                        => @Resource(name="id명") => 1.8이전에서만 사용
 *          = Container : 스프링에 등록된 클래스를 관리하는 영역 
 *                               ---------------
 *                               객체 생성 ~  객체 소멸 
 *                        종류 
 *                         BeanFactory 
 *                             |
 *                        ApplicationContext (XML전용)
 *                             | = AnnotationConfigApplicationContext
 *                                 | 어노테이션 기반 (Java전용)
 *                                 | 보안 
 *                      WebApplicationContext
 *                      <bean> : 클래스 1개 등록  
 *                      <context:component-scan basepackage=""> : 부트에서는 자동 인식 
 *                                             => default 패키지안에 설정한다 
 *                                             => com.sist.web
 *                             : 패키지단위로 등록 
 *                             : 객체 선택 
 *                               @Component : 일반 클래스 
 *                                            Open API , AOP ...
 *                               @Repository : DAO = 데이터베이스 연동 
 *                               @Service : BI(통합) 
 *                                          DAO여러개 사용 
 *                                          부가적인 부분
 *                                          = 로그인 (세션 저장)
 *                                          = 중복체크
 *                               @Controller : 화면 UI 
 *                                             화면 제어 / 출력 데이터 전송
 *                               @RestController : 파일 제어(X)
 *                                             데이터만 전송이 가능 
 *                                             ----------
 *                                             다른 언어와 연동 
 *                                             => Vue/React/모바일 
 *                                             => JSON
 *                               @ControllerAdvice : 모든 Controller에 예외처리를 공통으로 사용
 *             = AOP : 횡단지향적 프로그램 
 *                     => OOP에서 불가능한 프로그램을 제공 
 *                     => OOP를 보완
 *                     => OOP에서는 자동 호출이 불가능 
 *                        --- 소스 중복이 있는 경우 
 *                            | 메소드(클래스 한곳) / 여러개의 클래스 사용시 
 *                                                => 클래스를 이용한다
 *                            -------------------- 공통 모듈 
 *                     => AOP에는 자동 호출(Callback:시스템에서 자동 호출되는 메소드)
 *                        ---- 공통 사용시에 지정 
 *                        1. 어떤 메소드에서 호출 여부 => PointCut
 *                        2. 메소드의 어떤 영역에서 호출할지 여부  => JoinPoint 
 *                           JoinPoint 
 *                             = @Before : try 진입전 
 *                                         public void disp()
 *                                         {
 *                                            @Before
 *                                            try
 *                                            {
 *                                            }
 *                                         }
 *                              = @After : finally에서 호출 => 무조건 수행 
 *                              = @After-Throwsable : catch에서 수행 
 *                              = @After-Returning : 정상수행 => return이 된 상태 
 *                              = 코드 
 *                                ------ 1
 *                                  코드 
 *                                ------ 2 => @Around : 트랜잭션 / 보안 / 로그 파일 
 *                            JoinPoint / PointCut => Advice 
 *                                                   -------- 여러개 통합 : Aspect
 *                            => 클래스의 기능별 분리가 되어 있다 : 어노테이션 사용 
 *                               유지보수가 편리하다 
 *                        = MVC 
 *                        1. 클라이언트 요청 발생 
 *                           <a> <form> : html => JS와 호환성이 떨어진다
 *                        2. 톰캣(내장)에 전송
 *                        3. 톰켓에서 DispatcherServlet로 전달 
 *                           미리 등록 
 *                        4. DispatcherServlet 
 *                               |
 *                             Controller중에 => URI를 가지고 있는 메소드 찾기 
 *                                              => @GetMapping / @PostMapping
 *                             ---------------------- HandleMapping
 *                        5. 데이터를 전송할 JSP/HTML이 지정 => return 
 *                           => 데이터 전송 : return "폴더/파일명";
 *                              => HttpServletRequest / Model (권장)
 *                           => 기존의 설정된 Mapping호출 : return "redirect: URI명";
 *                        6. 화면 출력 => 출력에 필요한 데이터 전송 : ViewResolver
 *                                      => 경로명 / 확장자 전송 
 *                                         prefix  suffix 
 *                        7. 화면 UI 
 *                           = JSP 
 *                           = ThymeLeaf 
 *                           = React/Vue 
 *                            
 *                        = JDBC 
 *                           = ORM 
 *                             ---- MyBatis / JPA(Hibernate) => dataSet 
 *                                  | XML에서 주로 사용 
 *                      ---------------- 스프링의 기본 
 *                  ThymeLeaf 
 *                  ----------
 *                     주요기능 
 *                       => Vue와 비슷 => 태그안에서 제어문
 *                            <div v-for=""> <div th:each="vo:${list}">
 *                                            => 자바에서 사용하는 데이터를 그대로 사용
 *                       => 서버 사이드 렌더링 엔진 
 *                          -------------- HTML로 변환 
 *                       => 화면 UI => Front단 
 *                       => 자바와 호환성 
 *                       => JSP보다 현대적이고 구조겆 
 *                       => HTML을 브라우저에서 실행시 정상적으로 수행 
 *                       => 권장 상태 
 *                    ---------------------------------------
 *                                  ThyemeLeaf      JSP
 *                    ---------------------------------------
 *                    HTML파일을        실행 가능       불가능 
 *                    바로 실행 여부
 *                    ---------------------------------------
 *                    SpringMVC통합      매우우수       제한적 
 *                    ---------------------------------------
 *                    템플릿 문법          현대식         구식
 *                    ---------------------------------------
 *                     속도               빠름          느림
 *                    ---------------------------------------
 *                    현재 트랜드        아주 많이 사용   사용하지 않는다
 *                                                  ** 유지보수 
 *                                    Vue / React 
 *                    ---------------------------------------  
 */
@Controller
public class FoodController {
   @GetMapping("/")
   public String main_main(Model model)
   {
	   model.addAttribute("msg", "Hello ThymeLeaf!!");
	   return "main"; // .html => main.html
   }
}






