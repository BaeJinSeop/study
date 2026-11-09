# 기초 다시 쌓기

9년차 백엔드 개발자(Java/Kotlin)가 CS 기초를 다시 공부하고 기록하는 저장소입니다.

AI가 코드를 대신 짜주는 시대일수록, 시스템이 **왜** 그렇게 동작하는지 직접 이해하고 설명할 수 있어야 한다고 생각해서 시작했습니다.

- 커리큘럼 & 진행 현황: [CURRICULUM.md](./CURRICULUM.md)
- 공부 방식: Claude와 함께 ([CLAUDE.md](./CLAUDE.md))
- 블로그: [velog](https://velog.io/@jinseop-dev/posts)

## 공부 원칙

1. **실무에서 출발한다** — 겪었던 문제나 대충 알고 넘어갔던 지점에서 시작해 원리로 내려간다.
2. **직접 확인한다** — 읽기만 하지 않고 실험 코드, 명령어, 측정으로 확인한다.
3. **AI에게 맡기지 않고, AI와 함께** — Claude와 같이 공부하되, 설명을 듣기 전에 먼저 생각하고 실행하기 전에 먼저 예측한다.
4. **글로 설명할 수 있어야 아는 것이다** — 모든 주제는 글 한 편으로 끝낸다.
5. **꾸준함 > 완벽함** — 주 10시간. 주제당 1~2주.

## 구조

```
cs/01-os/lab/                    # 실험 코드
algorithm/<유형>/BOJ_1234.java   # 알고리즘 풀이
templates/                       # 글·풀이 템플릿
private/                         # 글 초안, 문체 규칙 (별도 비공개 레포)
```

## 작성 규칙

- 글은 [templates/post.md](./templates/post.md), 풀이는 [templates/Solution.java](./templates/Solution.java)를 복사해서 시작한다.
- 실험 코드와 풀이는 빌드 도구 없이 단일 파일로 실행한다: `java Foo.java < input.txt` (JDK 11+)
- velog에 발행하면 CURRICULUM.md의 체크박스를 채우고 글 링크를 단다.
- 이미지는 velog에 따로 업로드한다. (레포 상대경로는 velog에서 깨진다)
