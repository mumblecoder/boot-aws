# boot-aws
스프링부트와 AWS로 혼자 구현하는 웹사이트 책보고 따라하는 프로젝트






-------------------------------------
#### AWS 사용 중 발생한 문제
1. config 파일에 호스트를 추가했는데 nodename nor servname provided, or not known 에러 발생
- 나의 경우 config 파일에 권한 설정은 잘되어있었지만 소유주가 root로 설정되어서 발생한 에러였음. chown 명령어를 사용해 변경해줘서 해결

2. variables 값이 변경되지 않는 문제 
- global variable의 값은 변경되었지만 variable 값 조회시 적용되지 않았다. 책을 다시 순서대로 보다보니 아래 쿼리를 놓쳤었다.
```
use freelec_springboot2_webservice 
```
- 위 쿼리 실행후 다시하니 variable 값이 변경되어 있었다.

#### AWS 서버 생성 후 해야 할 일
1. Java 8 설치
```
sudo yum install -y java-1.8.0-openjdk-devel.x86_64
```
2. 타임존 변경
```
sudo rm /etc/localtime
sudo ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

3. HOSTNAME 변경
```
sudo vim /etc/sysconfig/network
HOSTNAME=호스트네임  수정
수정 후 sudo reboot 명령어 실행

sudo vim /etc/hosts
127.0.0.1   호스트네임  추가
저장 후 curl 호스트네임 명령어로 테스트 진행
```

