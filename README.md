# [ 프로젝트 소개 ]

2020년 1학기에 '소프트웨어 시스템개발' 수업에서 진행한 팀 프로젝트입니다.

Spring MVC 구조와 JDBC를 이용해 반려동물 커뮤니티를 제작했습니다.

Java와 Js, Oracle DBMS, Ajax, Bootstrap, REST 서비스 등 다양한 기능을 사용했습니다.

기본적인 커뮤니티의 로그인, 회원가입 과 게시글, 덧글, 추천기능을 포함하고 있습니다.

그 외에 다양한 기능이 있는 **정보게시판, 질문게시판, 중고게시판, 공구게시판, 매칭게시판, 리뷰게시판**이 존재합니다.

이밖에도 모든 조건들에 대한 validation과 Interceptor, 사진첨부, 페이징 등을 구현하였습니다.

네이버의 Smart Editor Api, 쇼핑 api, 자동완성, 카카오 Map Api 등 다양한 api를 사용했습니다.

사용자의 ID와 PW에는 Spring Security가 적용되어 있습니다. 

<br/>

# [ 게시판별 소개 ]

1. 베스트게시판

   ![image](https://user-images.githubusercontent.com/64277114/90982036-87418400-e59f-11ea-89e3-b9449ead9f72.png)

   🐶 index에 나타나는 화면으로, 일간 및 주간 베스트 게시글을 보여줍니다.

   🐶 가장 많은 추천수를 받은 게시글 순으로 3개씩 보여줍니다.

   <br/>

2. 정보게시판

   ![image](https://user-images.githubusercontent.com/64277114/90982131-236b8b00-e5a0-11ea-96a6-c9d078029f4b.png)

   🐶 회원들간의 정보공유를 위한 게시판입니다.

   🐶 가장 기본적인 게시글/덧글 작성, 수정, 삭제와 추천하기/추천취소, 검색 기능이 있습니다. 

   🐶 게시글 작성폼은 네이버 smart editor를 사용해 사진 첨부가 가능합니다.

   <br/>

3. 질문게시판

   ![image](https://user-images.githubusercontent.com/64277114/90982147-4138f000-e5a0-11ea-9827-fc78dc38fdb0.png)

   🐶 자유롭게 질문과 답변을 올릴 수 있는 게시판입니다. 

   🐶 질문에 대한 답변을 글 작성자가 채택하면 제목에 [채택완료]를 띄워줍니다.

   🐶 게시글 상세보기 화면의 덧글에서 하나의 덧글을 채택 가능합니다.

   🐶 답변이 채택된 글과 덧글은 수정과 삭제가 제한됩니다.

   ![image](https://user-images.githubusercontent.com/64277114/90982196-83623180-e5a0-11ea-9b91-3a6495b65cd6.png)

   <br/>

4. 중고게시판

   🐶 중고물품을 사고 팔 수 있는 게시판입니다.

   🐶 중고게시판에서는 추천 기능 대신 장바구니 버튼이 있으며 누르면 장바구니에 담깁니다.

   🐶 장바구니에서는 원하는 상품을 체크해 주문할 수 있습니다.

   🐶 ORDER 버튼을 누르면 결제창으로 이동하며 결제창에서는 정규표현식을 사용해 validation을 합니다.

   🐶 판매가 완료되었으면 더 이상 장바구니에 물품을 담을 수 없습니다.

   ![image](https://user-images.githubusercontent.com/64277114/90982244-e784f580-e5a0-11ea-9ebb-6b5b7bbac999.png)

   <br/>

5. 공구게시판

   ![image](https://user-images.githubusercontent.com/64277114/90982317-5c582f80-e5a1-11ea-9ceb-94dd1895e45b.png)

   🐶 회원들이 함께 물건을 싼 가격으로 구입할 수 있는 게시판입니다.

   🐶 스케줄러를 이용해 지정시간까지 목표인원에 도달했는지 판별해 성패여부를 띄워줍니다.

   🐶 상품명을 입력할 때 자동완성과 네이버 쇼핑 api를 이용해 최저가로 공구를 진행할 수 있습니다.

   🐶 datepicker를 사용해 공구 시작날짜와 마감날짜를 정할 수 있습니다.

   🐶 datepicker의 시작날짜는 현재날짜 이전으로는 선택이 불가합니다.

   ![image-20200824003549886](C:\Users\20gyr\AppData\Roaming\Typora\typora-user-images\image-20200824003549886.png)

   <br/>

6. 매칭게시판

   ![image](https://user-images.githubusercontent.com/64277114/90982463-33846a00-e5a2-11ea-853f-774bdc044ddf.png)

   🐶 조건에 맞는 펫시터를 구할 수 있는 게시판입니다.

   🐶 게시글 목록에서 사용자는 크기, 요일, 요금, 지역을 선택해 원하는 게시글만 필터링해 볼 수 있습니다.

   🐶 매칭게시판에는 회원가입시 펫시터로 분류된 회원만 글 작성이 가능합니다.

   🐶 작성자가 덧글을 쓴 사용자를 선택하면 [매칭완료] 표시를 해주고 글과 덧글 수정,삭제가 불가합니다.

   🐶 글 작성시 상세주소와 지도를 첨부할 수 있으며 카카오 Map api를 사용했습니다.

   ![image](https://user-images.githubusercontent.com/64277114/90982518-7d6d5000-e5a2-11ea-9af3-2f50059c6496.png)

   <br/>

7. 리뷰게시판

   🐶 펫시팅 서비스에 대한 후기를 남길 수 있는 게시판입니다.

   🐶 0.5점 단위로 평점을 매길 수 있습니다.

   🐶 펫시터 회원이거나 펫시터와 매칭된 적이 없으면 글을 작성할 수 없습니다.

   🐶 자신과 매칭된 적이 있던 펫시터를 선택해 후기를 남길 수 있습니다.

   ![image](https://user-images.githubusercontent.com/64277114/90982577-ec4aa900-e5a2-11ea-9a1b-405ee9600f7e.png)

8. 마이페이지

   🐶 마이페이지에서는 내가 쓴 글과 덧글을 게시판별로 확인할 수 있습니다.

   🐶 그 외에도 회원정보 수정, 내가 추천한 글, 장바구니, 주문내역을 확인 가능합니다.

   🐶 회원정보 수정을 하기에 앞서 modal 창으로 비밀번호를 입력받습니다.

   ![image](https://user-images.githubusercontent.com/64277114/90982610-2f0c8100-e5a3-11ea-816b-dcab58375b47.png) 

<br/>

# [ 그 외 기능들 ]

1. 회원가입 Validation 

   ![image](https://user-images.githubusercontent.com/64277114/90982832-f40b4d00-e5a4-11ea-872e-a76b71e53d89.png)

   <br/>

2. Login Validation

   ![image](https://user-images.githubusercontent.com/64277114/90982657-84e12900-e5a3-11ea-9e4c-b8a2c51dc11d.png) ![image](https://user-images.githubusercontent.com/64277114/90982686-b0fcaa00-e5a3-11ea-9d25-f52e369324a9.png)

   <br/>

3. 게시글 검색과 페이징

   ![image](https://user-images.githubusercontent.com/64277114/90982737-194b8b80-e5a4-11ea-9d99-7cf5a9f8439f.png)

   <br/>

4. Spring Security가 적용된 DB 조회 결과

   ![image](https://user-images.githubusercontent.com/64277114/90982760-4c8e1a80-e5a4-11ea-8e75-3874c5e761ea.png)

   <br/>

5. 주문 상세내역

   ![image](https://user-images.githubusercontent.com/64277114/90982773-6c254300-e5a4-11ea-8438-4b2169f9e32b.png)

   ![image](https://user-images.githubusercontent.com/64277114/90982793-9e36a500-e5a4-11ea-9964-258f4ed6b3c5.png)

   <br/>

<br/>

<br/>

이 프로젝트는 학과서버에 올라가 있는동안 test가 가능합니다.

test는 [여기](http://202.20.119.117/petMate/index)에서 할 수 있습니다. 😎

이 외에 더 많은 기능과 구현방법에 대한 설명은 [여기](https://drive.google.com/file/d/1V5UwLsKu-HChuZjV5EWdxkE_7K0QmQs7/view?usp=sharing)에서 참고 부탁드립니다.
