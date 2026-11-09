# 커리큘럼

- 주 10시간: **CS 7시간**(이론·실험 5h + 글 2h) + **알고리즘 3시간**
- 주제당 1~2주, 글 1편. 전체 약 1년~1년 반.
- 순서: OS → 네트워크 → DB → JVM → Spring → 설계 → 분산. 앞 단계가 다음 단계의 기반이 된다.
- 각 주제의 `—` 뒤는 글에 반드시 넣을 **실무 연결 포인트**다.
- 언어: 이론·실험은 **Java/JVM 기준**, 해당되는 주제는 "Kotlin에서는?" 섹션으로 비교한다.

발행하면 `- [x] 주제 — ... ([글](velog 링크))` 형태로 기록한다.

---

## Phase 0. 시작 (1주)

- [ ] 레포, velog 시리즈 세팅
- [ ] 첫 글: AI가 코드를 짜주는 시대에, 9년차가 기초를 다시 공부하는 이유

## Phase 1. 컴퓨터 구조 & 운영체제 (`cs/01-os`)

교재: [OSTEP](https://pages.cs.wisc.edu/~remzi/OSTEP/) (무료)

- [ ] CPU·메모리 계층과 캐시 — 캐시 라인과 false sharing, `@Contended`
- [ ] 프로세스와 스레드, 컨텍스트 스위칭 — 톰캣 스레드 풀 크기는 어떻게 정하나, 스레드 덤프 읽기
- [ ] 동기화: mutex, 세마포어, CAS — `synchronized` vs `ReentrantLock` vs `Atomic*`, 데드락 스레드 덤프 분석
- [ ] 가상 메모리와 페이징 — 컨테이너 OOMKilled vs `OutOfMemoryError`, `-Xmx`와 컨테이너 메모리 한도
- [ ] CPU 스케줄링 — 컨테이너 CPU limit과 throttling, `availableProcessors()`가 돌려주는 값
- [ ] 파일 디스크립터와 시스템 콜 — `Too many open files` 장애, `strace`로 보는 Java I/O
- [ ] I/O 모델: blocking/non-blocking, epoll — Tomcat NIO 커넥터, Netty/WebFlux가 적은 스레드로 버티는 이유

## Phase 2. 네트워크 (`cs/02-network`)

교재: 『HTTP 완벽 가이드』, [High Performance Browser Networking](https://hpbn.co) (무료)

- [ ] URL을 입력하면 일어나는 일 (전체 지도) — 장애가 나면 어느 계층부터 의심할 것인가
- [ ] TCP 연결 수립·종료, TIME_WAIT — TIME_WAIT 폭증, 커넥션 풀이 필요한 이유
- [ ] TCP 흐름·혼잡 제어 — 대용량 응답 지연, 소켓 버퍼
- [ ] HTTP/1.1 keep-alive → HTTP/2 → HTTP/3 — HTTP 클라이언트 커넥션 풀 설정, gRPC가 HTTP/2 위에 있는 이유
- [ ] 타임아웃 — connect/read timeout 차이, 타임아웃 없는 외부 호출이 스레드 풀을 고갈시키는 과정
- [ ] TLS/HTTPS — 인증서 만료 장애, mTLS, TLS를 어디서 종료하나(LB vs 앱)
- [ ] DNS — JVM DNS 캐시(`networkaddress.cache.ttl`), 도메인 전환 시 장애
- [ ] 로드밸런서 L4/L7, 프록시 — 헬스체크, graceful shutdown, `X-Forwarded-For`

## Phase 3. 데이터베이스 (`cs/03-database`)

교재: 『Real MySQL 8.0』, [Use The Index, Luke](https://use-the-index-luke.com) (무료)

- [ ] 스토리지 엔진과 B+Tree 인덱스 — 클러스터드 인덱스, PK 설계가 성능에 미치는 영향
- [ ] 실행계획 읽기 — 슬로우 쿼리 튜닝, 커버링 인덱스, 인덱스를 안 타는 쿼리
- [ ] 트랜잭션, 격리수준, MVCC — 재고 차감 동시성 문제, 갱신 손실(lost update)
- [ ] 락과 데드락 — 비관적/낙관적 락(JPA `@Version`), 데드락 로그 분석
- [ ] 커넥션 풀 — HikariCP 풀 크기 산정, 풀 고갈 장애
- [ ] 모델링과 정규화 — 반정규화 판단 기준
- [ ] 복제와 샤딩 — replica lag로 인한 읽기 불일치, 읽기/쓰기 분리
- [ ] Redis 내부 구조 — 싱글 스레드인데 빠른 이유, 큰 키·`KEYS` 명령 장애

## Phase 4. JVM & Java/Kotlin (`cs/04-jvm`)

교재: 『자바 병렬 프로그래밍』(Java Concurrency in Practice), 『자바 최적화』

- [ ] 클래스 로딩과 바이트코드 — `javap`로 Java·Kotlin 코드 디컴파일해보기
- [ ] JVM 메모리 구조 — 힙 덤프 분석, 메모리 릭 찾기
- [ ] GC (G1, ZGC) — GC 로그 읽기, Stop-the-world로 인한 장애
- [ ] JIT 컴파일 — 워밍업, 벤치마크를 JMH로 해야 하는 이유
- [ ] Java 메모리 모델 — `volatile`, happens-before, DCL 싱글톤
- [ ] 동시성 도구 — `ConcurrentHashMap`, `ExecutorService`, `CompletableFuture`
- [ ] 컬렉션 내부 구현 — `HashMap` 충돌과 트리화, `ArrayList` 확장 비용
- [ ] Virtual Thread vs Kotlin Coroutine — 둘 다 써본 입장에서의 비교, pinning 문제
- [ ] Kotlin 컴파일 결과 — data class, `inline`, `suspend`(CPS)가 바이트코드로 어떻게 바뀌나

## Phase 5. Spring 내부 (`cs/05-spring`)

교재: Spring 공식 문서 + 소스 코드 직접 읽기

- [ ] IoC 컨테이너와 빈 생명주기
- [ ] 프록시와 AOP — JDK 동적 프록시 vs CGLIB
- [ ] `@Transactional` 동작 원리 — self-invocation, 전파 속성, `readOnly`의 실제 효과
- [ ] 요청 처리 흐름 — 필터 → DispatcherServlet → 인터셉터 → 컨트롤러
- [ ] JPA 영속성 컨텍스트 — N+1, 지연 로딩, OSIV
- [ ] Spring Boot 자동 설정 — `@Conditional`, 스타터가 실제로 하는 일

## Phase 6. 설계 & 테스트 (`cs/06-design`)

교재: 『오브젝트』, 『클린 아키텍처』

- [ ] 객체지향 다시 보기 (SOLID) — 내 레거시 코드에서 위반 사례 찾기
- [ ] 디자인 패턴 — JDK/Spring 안에 숨어 있는 패턴 (Template Method, Strategy, Proxy)
- [ ] 레이어드 vs 헥사고날/클린 아키텍처 — 언제 과한가
- [ ] DDD 기초 — 애그리거트 경계와 트랜잭션 경계
- [ ] 테스트 전략 — 단위/통합 경계, Testcontainers, 테스트 더블

## Phase 7. 분산 시스템 & 시스템 디자인 (`cs/07-distributed`)

교재: 『데이터 중심 애플리케이션 설계』(DDIA), 『가상 면접 사례로 배우는 대규모 시스템 설계 기초』

- [ ] 일관성 모델, CAP/PACELC
- [ ] 분산 트랜잭션: 2PC, Saga, 아웃박스 패턴 — 주문·결제 연동 사례
- [ ] 메시지 큐 (Kafka) — 메시지 중복과 멱등 컨슈머, 순서 보장
- [ ] 캐시 전략 — cache-aside, 캐시 스탬피드, DB와의 정합성
- [ ] 분산 락 — Redis 분산 락의 한계
- [ ] 장애 대응 패턴 — 타임아웃·재시도·서킷 브레이커(Resilience4j), 재시도 폭풍
- [ ] Rate limiting — 토큰 버킷, 분산 환경에서 구현
- [ ] 관측성 — 로그·메트릭·트레이싱으로 장애 원인 추적
- [ ] 시스템 디자인 사례 — URL 단축기, 선착순 쿠폰, 알림 시스템

---

## Track. 알고리즘 · 코딩테스트 (`algorithm/`, CS와 병행, 주 3시간)

- 언어: **Java** (Kotlin을 지원하지 않는 코딩테스트가 있음)
- 문제 순서: [solved.ac CLASS](https://solved.ac/class) 순서를 따르고, 프로그래머스로 보충
- 규칙: **먼저 직접 푼다** → 막히면 Claude에게 단계별 힌트(유형 → 접근 → 핵심 아이디어) → 다 풀고 나서 코드 리뷰와 다른 풀이
- velog에는 문제마다 쓰지 않고, **단계가 끝날 때 유형 정리 글 1편**을 쓴다.

- [ ] 1단계: Java 코테 세팅(빠른 입출력), 구현·완전탐색·정렬·이분탐색
- [ ] 2단계: 스택·큐·덱·힙·해시, 투 포인터·슬라이딩 윈도우, 그리디
- [ ] 3단계: DFS/BFS, 백트래킹
- [ ] 4단계: DP
- [ ] 5단계: 그래프(다익스트라, 유니온 파인드, 위상 정렬, MST), 트리
- [ ] 6단계: 실전 — 시간 재고 모의고사, 기업 기출
