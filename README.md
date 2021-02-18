# boot-aws
스프링부트와 AWS로 혼자 구현하는 웹사이트 책보고 따라하는 프로젝트






-------------------------------------
AWS 연결 중 발생한 문제
1. config 파일에 호스트를 추가했는데 nodename nor servname provided, or not known 에러 발생
- 나의 경우 config 파일에 권한 설정은 잘되어있었지만 소유주가 root로 설정되어서 발생한 에러였음. chown 명령어를 사용해 변경해줘서 해결
