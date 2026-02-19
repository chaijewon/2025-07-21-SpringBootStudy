package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.dao.*;

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
}
