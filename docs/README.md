# 기능 목록 정리

1. Model
   - 자동차
     - 이름 저장
     - 전진 횟수 저장
2. View
   - 입력
     - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 메세지 출력
     - "시도할 회수는 몇회인가요?" 메세지 출력
   - 출력
     - "실행결과" 메세지 출력
     - 각 자동차 이름 출력
     - 각 차수별 실행 결과
     - "최종 우승 : XXX, XXX" 메세지 출력
3. Controller
   - 경주
     - 입력 View 호출
     - 출력 View 호출
     - 자동차 Model 호출 및 참가 자동차 목록 저장
4. Exception
   - IllegalArgumentException
     - 부적절한 시도 횟수 입력 시 발생
       - "[ERROR] 시도 횟수는 숫자여야 한다."
     - 자동차 이름 길이 초과 시 발생
       - "[ERROR] 자동차 이름은 5자 이하만 가능하다."
   - IllegalStateException