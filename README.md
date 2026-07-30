# 공공데이터를 활용한 EnjoyTrip 서비스

> Java 프로그램 구축

SSAFY 16기 서울 14반 고아라 김원희


---

## 개발 및 실행 환경 (Environment)

- **Language:** Java 8 / 11 이상
- **GUI Framework:** Java Swing
- **Data Format:** XML, CSV

---

## 패키지 구조 (Package Structure)
```
com.ssafy.trip
├── model/                             # 데이터 및 비즈니스 로직
│   ├── dao/                           # 데이터 접근 계층
│   │   ├── TripDao.java               # 관광지 데이터 DAO 인터페이스
│   │   ├── TripDaoImpl.java           # 관광지 데이터 DAO 구현체
│   │   ├── TripNearDao.java           # 주변관광지 데이터 DAO 인터페이스
│   │   └── TripNearDaoImpl.java       # 주변관광지 데이터 DAO 구현체
│   ├── dto/                           # 데이터 전달 객체
│   │   ├── TripDto.java               # 관광지 정보 DTO
│   │   ├── TripSearchDto.java         # 관광지 검색 조건 DTO
│   │   └── TripNearDto.java           # 주변 관광지 정보 DTO
│   └── service/                       # 비즈니스 로직 계층
│       ├── TripService.java           # 관광지 서비스 인터페이스
│       ├── TripServiceImpl.java       # 관광지 서비스 구현체
│       ├── TripNearService.java       # 주변 관광지 서비스 인터페이스
│       └── TripNearServiceImpl.java   # 주변 관광지 서비스 구현체
├── util/                              # XML 파싱 Utility
│   ├── TouristDestinationSAXHandler.java # SAX 파싱 핸들러
│   ├── TouristDestinationSAXParser.java  # SAX 파서 실행 클래스
│   └── TripNearCSVParser.java            # CSV 파서 실행 클래스
└── view/                              # 메인 UI
    ├── TripInfoView.java              # 메인 관광지 정보 화면
    └── TripNearView.java              # 주변 관광지 정보 화면
```
---

## 요구사항 명세

| 순번 | 분류 | 요구사항 명 | 요구사항 명세 | 우선 순위 |
|:---:|---|---|---|:---:|
| F101 | 여행 | 관광지 정보 조회 | 관광지 정보를 얻어와 화면에 목록으로 표시 | 필수 |
| F102 | 여행 | 관광지 정보 조건 검색 | 관광지명, 주소를 조건으로 해당하는 관광자 정보들을 조회 | 필수 |
| F103 | 여행 | 관광지 정보 상세 조회 | 관광지 목록 화면에 원하는 관광지 클릭 시, 왼쪽 화면에 상세 정보 표시 | 필수 |
| F104 | 기타 | 지역 축제 정보 조회 | 관광지 주변에서 개최되는 지역 축제 정보 조회 | 심화 |
| F105 | 기타 | 주변 상권 정보 조회 | 서울 주변의 상권 정보를 조회 | 심화 |

## 요구사항 상세

### 1. 관광지 정보 조회

- 요구 사항 번호: F101
- XML 로 제공된 관광지 정보를 Parsing 하여 자바의 객체 형태로 변경하고, Swing 을 사용하여 화면에 표시한다
<img width="1178" height="787" alt="image" src="https://github.com/user-attachments/assets/ffd7b761-7f4b-4661-873e-0a2ddacd431e" />


### 2. 관광지 정보 조건 검색

- 요구 사항 번호: F102
- 관광지 정보 목록화면의 상단에 검색 조건과 검색어를 입력한 뒤 검색버튼을 클릭하면 조건에 맞는 관광지 정보를 표시한다.
#### 관광지명 키워드로 검색 시
<img width="593" height="691" alt="image" src="https://github.com/user-attachments/assets/224c1af8-e365-4975-a555-f9f47aa1a538" />
#### 주소 키워드로 검색 시
<img width="596" height="584" alt="image" src="https://github.com/user-attachments/assets/c390b33c-2270-4e1b-b90d-73f5c629a365" />


### 3. 관광지 정보 상세 조회

- 요구 사항 번호: F103
- 오른쪽 목록화면의 관광지를 클릭하면 왼쪽에 상세 조회 결과 화면이 출력된다.
<img width="1177" height="783" alt="image" src="https://github.com/user-attachments/assets/86f0d564-4cb0-4d35-b351-f8ba879f610b" />


### 4. 지역 축제 정보 조회

- 요구 사항 번호: F104
- 하단의 버튼을 클릭하면 지역 축제 정보가 출력된다.
<img width="1177" height="783" alt="image" src="" />

### 5. 주변 상권 정보 조회

- 요구 사항 번호: F105
- 왼쪽 상세 화면 위쪽에 주변 관광지 버튼을 클릭하면 서울 주변 상권 정보가 출력된다.
<img width="1177" height="783" alt="image" src="https://github.com/user-attachments/assets/4822240a-ca53-48c2-afd2-713fcc0eccef" />

