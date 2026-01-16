package com.sist.web.vo;

import lombok.Data;

/*
 *    sudo apt-get update
 *    sudo apt-get install openjdk-17-jdk
 *    => sudo nano ./.bashrc
 *    => export JAVA_HOME=/usr~
 *    => export PATH=$PATH:$JAVA_HOME/bin
 *    => ctrl+o enter ctrl+x
 *    => source ./.bashrc
 *    -----------------------------------
 *    => java -version 
 *    => docker 설치 
 *    
 *    ---------------------------
 *    mkdir app 
 */
@Data
public class ChatMessage {
  //private String type; // 전체 / 1:1 
  private String sender;
  private String receiver;
  private String message;
  //private String time;
}
