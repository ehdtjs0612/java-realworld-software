# java-realworld-software
실전 자바 소프트웨어 개발

## 코드 유지보수성을 높이기 위해.
- 특정 기능을 담당하는 코드를 쉽게 찾을 수 있어야 한다.
- 코드가 어떤 일을 수행하는지 쉽게 이해할 수 있어야 한다.
- 새로운 기능을 쉽게 추가한거나 기존 기능을 쉽게 제거할 수 있어야 한다.
- **캡슐화**가 잘 되어 있어야 한다. 코드 사용자에게는 세부 구현 내용을 감추고 사용자가 쉽게 코드를 이해하거나 바꿀 수 있어야 한다.


#### 개발자의 궁극적인 목표는 응용프로그램의 복잡성을 관리하는 것이다. 새로운 요구사항이 생길때마다 쉽게 기능을 추가할 수 있어야 한다. (side effect 최소화)


## 클래스 수준 응집도.
응집도 : 클래스나 메서드의 책임이 얼마나 강하게 연결되어 있는지의 정도이다. 높은 응집도는 개발자의 목표이고 누구나 쉽게 코드를 찾고, 이해하고, 사용할수 있도록 해야한다.

이 코드에서 BankStatementCSVParser 클래스를 **그룹화**하여 이 클래스의 응집도가 매우 높다.


현재 프로그램의 진입점인 BankTransactionAnalyzer는 파서, 계산, 출력 등 응용프로그램의 다양한 부분을 연결해준다.

[cd90f7f](https://github.com/ehdtjs0612/java-realworld-software/commit/cd90f7fb2d856b67e08a9fe81cbcabe1788b395d) 을 보면 계산작업을 하는 로직이 BankTransactionAnalyzer내에 정적으로 선언되어 있다.

파싱이나 결과 전송과는 직접적인 관련이 없음,  
**고로 위 커밋 로그는 응집도가 떨어지는 클래스의 사례이다.**

[0197bc4](https://github.com/ehdtjs0612/java-realworld-software/commit/0197bc497a236937766e235621747d4a5a1079f1)처럼 별도의 클래스로 분리해주자!
