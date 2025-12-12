package com.sist.web.controller;
import java.util.*;

import org.springframework.stereotype.Controller;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class BoardController {
   private final BoardService bService;
}
