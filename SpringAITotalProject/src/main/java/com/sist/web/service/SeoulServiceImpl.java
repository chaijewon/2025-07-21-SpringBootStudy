package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SeoulServiceImpl implements SeoulService {
  private final SeoulMapper mapper;

  @Override
  public List<String> seoulGetTitle() {
	// TODO Auto-generated method stub
	return mapper.seoulGetTitle();
  }

  @Override
  public SeoulVO seoulData(String title) {
	// TODO Auto-generated method stub
	return mapper.seoulData(title);
  }
}
