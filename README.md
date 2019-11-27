# ⭐️ 서비스 소개

밀레니엄 세대를 중심으로 **구독 경제**가 일상에 깊숙이 자리 잡고 있다. 구독 경제(subscription economy)란 소비자가 정기적으로 비용을 지급하여 원하는 상품을 배송받거나, 일정 기간 서비스를 이용하는 것을 뜻한다.

 현재 구독 경제는 2020년 594조 원 전망을 나타내며 소비의 새로운 패러다임으로 자리 잡았다. 하지만 서비스를 구매하던 기존의 방식이 익숙한 소비자들은 여전히 제한적인 서비스만을 이용하거나, 다양한 결재체계로 흩어져 구독 중인 서비스로 인해 관리에 어려움을 겪고 있다. 따라서 우리 팀은 신한 계열사들의 API들을(목록 아래 기제) 사용하여서 통합적으로 구독 서비스를 관리할 수 있는 플랫폼을 만들고자 한다.\
\
\
\
[]()
# 📽 시연 영상
https://drive.google.com/drive/folders/1Y-TnhOSvX0GOw-QpAYguQ8f8Mc4y0hNJ

\
\
\
\
[]()
 # 📱 어플리케이션 캡쳐화면

 | MainActivity | MyPageActivity | CardInfoActivity |
|:---:|:---:|:---:|
| ![image](https://user-images.githubusercontent.com/35513039/69621227-05f5a900-1082-11ea-940c-2f04d0329cf4.png)|![image](https://user-images.githubusercontent.com/35513039/69621291-29b8ef00-1082-11ea-9607-0a05044e38e1.png) |![image](https://user-images.githubusercontent.com/35513039/69621319-389fa180-1082-11ea-8160-b23f7ca3821c.png) |

| CardActivity | CardRegisterActivity | ChatActivity |
|:---:|:---:|:---:|
| ![image](https://user-images.githubusercontent.com/35513039/69621333-405f4600-1082-11ea-8bc7-55792b9d86e8.png)| ![image](https://user-images.githubusercontent.com/35513039/69621380-5836ca00-1082-11ea-8632-ab59c30647ed.png) |![image](https://user-images.githubusercontent.com/35513039/69621390-5cfb7e00-1082-11ea-9e50-72bca1f1e7ac.png) |

| SubscriptCalenderFragment | SubscriptCalenderFragment | SubscriptManageFragment |
|:---:|:---:|:---:|
|![image](https://user-images.githubusercontent.com/35513039/69621461-85837800-1082-11ea-89bf-57ed8a690c7f.png)|![image](https://user-images.githubusercontent.com/35513039/69621477-8caa8600-1082-11ea-80f7-ee1f94dfdcdf.png)|![image](https://user-images.githubusercontent.com/35513039/69621509-9633ee00-1082-11ea-83d6-aa4339d5d661.png) |

| AnalysisActivity | CategoryFragment | DetailedActivity | CategoryContentFragment |
|:---:|:---:|:---:|:---:|
|![image](https://user-images.githubusercontent.com/35513039/69621498-916f3a00-1082-11ea-88ed-a7b14d04d012.png)|![image](https://user-images.githubusercontent.com/35513039/69621573-b6fc4380-1082-11ea-859b-a790b351cfaf.png)|![image](https://user-images.githubusercontent.com/35513039/69621582-bbc0f780-1082-11ea-8ade-62eff06bc5c4.png) |![image](https://user-images.githubusercontent.com/35513039/69697677-7ce47d80-1126-11ea-904b-7204ff5a667e.png)

\
\
\
\
[]()
## 🂠 구현한 패턴
**Repository Pattern** \
데이터를 가져오는 곳을 패턴(일정한 규칙)을 이용하여 구현하는 방법 \
앱 내부 DB(Room, Realm 등)에서 가져올지 서버DB에서 가져올지 추상화를 한다.\
Repository 객체에서는 서버나 로컬에서 가져온 데이터를 가공하거나 데이터 흐름을 정의해 주는 역할을 한다.
이 프로젝트에서는 짧은 시간안에 신한 API를 이용해서 구현하는 것이 해커톤의 취지이기 때문에 Cache를 사용하지 않고 Retrofit 라이브러리를 사용해 Remote 만을 사용하였다. 

\
\
[참고 블로그(우아한 형제들)](http://woowabros.github.io/experience/2019/01/17/baeminapp-clean-architecture.html)
\
\
![image](https://user-images.githubusercontent.com/35513039/69628698-29732080-108f-11ea-8271-878ee284546c.png)

**Foldering**

<img src="https://user-images.githubusercontent.com/35513039/69630209-1f055680-1090-11ea-9f76-63c875af537d.png" width="40%"/>

data 패키지에서는 response객체를 쉽고 빠르게 만들어주는 [Kotlin data class File from JSON](https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-/) PlugIn 을 사용하였다.

\
\
\
[]()
## 📚 주요 라이브러리

📕  
``` 
implementation 'com.google.android.material:material:1.0.0'
```

주로 cardview, recyclerview 를 커스텀하기 위해 사용한다. 또한 버튼 탭이나 스크롤 탭, 스크롤 시 상단 탭이 없어지는 AppBar를 구현할 수 있다.

이 프로젝트에서는  CardView와 ViewPager, RecyclerView를 사용하기 위해 라이브러리는 이용하였다.

[참고자료(github)](https://github.com/material-components/material-components-android)

\
\
📕  
```
implementation 'com.squareup.retrofit2:retrofit:2.6.2'
implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.6.2'
```
서버와 HTTP 규약을 통해 데이터를 주고 받을 수 있는 라이브러리 POST,GET,PUT,DELETE 통신 매서드를 이용하여 서버에게 JSON형식으로 데이터를 주고 (request) 서버 DB의 데이터를 가져올 수 있다.(response) 

이 프로젝트에서는 JSON형식으로 주고 받을 때 call 객체와 Single 객체를 사용하였다.

[참고자료(공식 홈페이지)](https://square.github.io/retrofit/)

\
\
📕  
```
implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
```
그래프를 만들어 주는 라이브러리다. 선 그래프, 막대 그래프, 원 그래프, 분산형 차트, 캔들 스틱 차트, 버블 차트, 레이더 차트 등이 있다.

이 프로젝트에서는 **LineChart**와 **PieChart**를 사용하였다\
[참고 자료(github)](https://github.com/PhilJay/MPAndroidChart)

\
\
\
\
[]()
## 💡 핵심 기술
### 🔍 **RxJava**
자바로 리액티브 프로그래밍을 할 수 있는 라이브러리며 비동기 프로그래밍과 함수형 프로그래밍 기법을 함께 활용한다.
리액티브 프로그래밍은 복잡한 비동기 프로그램을 쉽게 만들 수 있게 도와준다. 리액티브의 의미에서 알 수 있듯이 이벤트(스크린 터치, 마우스 클릭, 키 입력, 서버의 비동기 응답)에 소비자가 비동기로 반응하여 처리한다. 또한 비동기에서 처리하기 힘든 에러 처리나 데이터 가공을 쉽게 할 수 있게 도와주기도 한다. 이벤트를 콜백이 아닌 데이터의 모음으로 모델링 하기 때문이다.

기존의 명령형 프로그래밍은 주로 컴퓨터 하드웨어를 대상으로 프로그래머가 작성한 코드가 정해진 절차에 따라 순서대로 실행된다. 그러나 리액티브 프로그래밍은 데이터 흐름을 먼저 정의하고 데이터가 변경되었을 때 연관되는 함수나 수식이 업데이트 되는 방식이다.

이 프로젝트에서는 Single 클래스와 subscribeOn(), subscribe(), 을 사용하였다.\
**Single** 클래스는 오직 1개의 데이터만 발생하도록 한정한다. 이러한 특징을 이용하여 서버 API를 호출할 때 사용하였다.\
**subscribeOn()** 함수는 구독자가 subscribe() 함수를 호출하여 구독할 때 실행되는 스레드를 지정한다. 이 프로젝트에서는 네트워크상의 요청, 파일 입출력, DB쿼리 등을 작업하는 IO 스케줄러를 사용하였다.\
**subscribe()** 함수는 Observable을 구독한다. Observable은 subscribe()함수를 호출해야 비로소 변화한 데이터를 구독자에게 발행한다. 옵서버 패턴과 동일하다고 보면된다. 반드시 데이터를 수신할 구독자가 subscribe()함수를 호출해야 Observable에서 데이터가 발행한다. 이 프로젝트에서는 서버에서 응답받은 데이터를 구독하여 adapter클래스 함수에 전달하는 내용을 구현하였다. \
**observeOn()** 함수는 Observable에서 생성한 데이터 흐름이 여기저기 함수를 거치며 실행될 때 동작이 어느 스레드에서 일어나는지 지정할 수 있다. 이 프로젝트에서는 AndroidSchedulers.mainThread()를 인자로 구현하여 데이터 흐름이 UI에서 실행되도록 구현하였다.

\
[참고자료(공식문서)](http://reactivex.io/)

### 🔍 **DataBinding**
프로그래매틱 방식이 아니라 선언적 형식으로 레이아웃의 UI구성요소를 앱의 데이터 소스와 결합할 수 있는 지원 라이브러리\
레이아웃 파일에서 구성요소를 결합하면 활동에서 많은 UI 프레임워크 호출을 삭제할 수 있어 파일이 더욱 단순화되고 유지관리 또한 쉬워진다. 앱 성능이 향상되며 메모리 누수 및 null 포인터 예외를 방지할 수 있다.\
이 프로젝트에서는 주로 BindingAdapter를 구현하였으며 data Class에 있는 변수들을 xml에 바로 binding 해주었다. viewHolder 클래스의 코드를 줄일 수 있는 장점이 있다.

[참고자료(공식문서)](https://developer.android.com/topic/libraries/data-binding?hl=ko)

### 🔍 **AppUsageStatistics**
어플리케이션 사용량을 보여주는 API이다. 사용자의 핸드폰에 설치된 어플리케이션의 사용량, 마지막 사용시간등을 분석하여 리스트로 보여준다. `android.permission.PACKAGE_USAGE_STATS`을 manifest에 구현해야 한다. 그리고 환경설정>보안>Apps with usage access에 들어가서 권한설정을 해야한다.

\
[참고자료(github)](https://github.com/googlesamples/android-AppUsageStatistics)


\
\
\
[]()
## ❗️ 해커톤 준비 팁 ❗️

1. **팀원과 기술 스택을 맞춘다.**


    해커톤 서류 통과가 된 후 나와 같이 안드로이드를 작업한 친구와 3일을 코딩작업을 하였다. \
    첫 째날은 repository pattern의 개념을 익히고 구현하였다. 그리고 github을 통해 코드를 공유하였다. \
    코딩 스타일을 맞추기 위해 작업을 했다. 우선 kotlin convention, xml naming 가이드 라인에 따라 작업하는 것을 하였다. \
    둘 째날은 OPEN API를 통해 retrofit 라이브러리 작업을 하였다. 대회 당일 어떤 형식의 API가 나올지 모르는 상태에서 유연하게 대처하기 위해 미리 한번 사용해보고 서로 코딩 스타일을 맞추는 방식으로 진행하였다. \
    셋 째날은 서버 사람들과 파일링 방식과 사용할 라이브러리를 샘플을 만들어 보는 작업을 하였다.\
    이렇게 팀원과 코딩 스타일을 맞추면 git에서 충돌이 날 때 빠르게 해결을 할 수 있고 다른 사람의 코드를 빠르게 이해할 수 있어 이슈가 생기면 다른 사람의 코드라도 빠르게 해결할 수 있다. \
    서로의 코드를 보면서 내 스타일로 맞추자며 고집 부리지 않고 더 좋은 clean code를 위해 스터디하며 유연하게 작업을 하며 진행해 나갔다.

2. **어떤 기술을 사용할지 조사한다.**

    기획을 하면서 어떤 라이브러리가 필요한지 구현이 가능한지 빠르게 판단하는 것이 중요하다 러닝 커브가 높은 라이브러리를 사용하다가 해커톤 당일 개발 속도가 느려질 수 있기 때문에 자신이 구현할 수 있는지 자신에 실력에 대한 객관화 작업이 필요하다 \
    나는 retrofit 라이브러리를 call 객체를 사용해봤지만 요즘에 RxJava로 프로그래밍을 하고 있어서 Single 객체로 작업을 하였다. 러닝커브가 높은 라이브러리이지만 가장 익숙하고 빠르게 구현할 수 있을 것 같아 RxJava를 사용하였다. \
    이 프로젝트에는 사용자가 적게 사용하는 구독 서비스를 판단하여 다른 구독 서비스를 추천하는 기능이 있었다 적게 사용하는 어플리케이션을 분석하려면 AppUsageStatistics이라는 API를 사용해야 했다. 이것을 통해 내 핸드폰에 미리 적용해보고 가장 많이 사용하는 어플과 적게 사용하는 어플을 볼 수 있었다.

3. **보일러 플레이트 작업을 한다.**

    대회 당일까지 픽스된 뷰는 없는 상태였고 API를 통해 통신을 할 수 없는 상태였기 때문에 클라이언트 입장에서는 준비할 수 없었다. 그러나 아무 작업도 하지 않으면 안된다. 그래서 보일러 플래이트 작업을 하였다. 보일러 플래이트란 소프트웨어 용어로 개발 초기에 재활용할 수 있는 소스를 만들어 두는 것을 말한다. 우리 팀은 객체와 xml를 구현하였다. 자세하게는 사용할 color들을 문자화하고 xml에서 많이 사용하는 background 들을 만들어 두었다. 라이브러리를 미리 조사하여 sync를 하였다. 그리고 repository 패턴에 맞춰서 데이터를 처리하기 위해 filing, foldering 하는 작업을 하였다.\
    3일 동안 2명이서 9개의 activity, 10개의 fragment, 12개의 Adatper, 22개의 data Class, 32개의 xml 총 85개의 파일을 만들었다.

4. **욕심을 부리지 않는다.**

    공모전이나 해커톤 대회에 나갈때면 자신의 실력을 보이기 위해 수준 높은 프레임워크나 라이브러리 또는 도전적인 작업을 해보고 싶은 욕구가 있다. 하지만 이를 지양해야한다. \
    해커톤의 취지는 사용자가 서비스를 매력있게 생각해야 하는게 중요하다. 어떤 기술을 사용하는지 보다 어플리케이션의 디자인이나 편의성이 중요하다. 그래서 우리팀은 로그인 기능과 스플래쉬 화면을 과감하게 보류하였다. 중요한 것은 사용자가 구독 사용량을 편하게 관리하는 것과 구독 추천 서비스 기능에 초점을 맞추었다. 그래서 무엇보다 메인 화면과 통계 화면이 중요하게 생각했다. 사용자가 어플리케이션을 사용하는 순서대로 작업을 진행하는 것 보다 메인 기능부터 작업을 해야한다.

5. **즐기자!**

    무박 3일 간의 시간은 정말 힘든 시간이었다. 상금이 달린 경쟁, 대회였기 때문이다. 우리 팀원들도 3일동안 3시간 정도 잠을 잘 정도로 열정이 가득했다. 다른 팀도 마찬가지였다. 경쟁 심리가 큰 팀은 거의 말을 하지 않고 회의도 작은 소리로 하거나 아예 밖에 나가서 회의를 하였다. 거의 대부분의 팀이 야식먹으면서 코딩을 했다 아예 먹지 않는 팀도 있었다. 하지만 우리 팀은 따로 테이블에 자리 잡아 사진도 찍고 여유롭게 야식을 먹었다. 광고라도 하듯 핸드폰에 어플리케이션을 띄어놓고 자리를 비우고 그랬다. 행사장에서 지원해준 샤워시설과 식당도 이용했다. 식당에서 수육과 막국수, 만두 전골이 나왔는데 안 먹을 수 없었다.
    
    처음 강남에서 만나서 회의를 하고 해커톤 마지막날까지 2주간의 시간이었다. 236개 팀이 경쟁하는 가운데 장려상을 받은 건 팀원들의 열정이 있었기 때문이라고 생각한다. 감정적으로 말하지 않고 프로젝트를 위해 조사하고 공부하며 임하는 자세를 배웠다. 많은 작업을 단시간에 끝내야 하고 피곤하고 예민한 상황에서도 짖궂은 장난을 쳐도 받아주고 삐지지 않고 기분 나쁜 티 내지않았던 팀원들과 같이 프로젝트할 수 있어서 즐거웠고 행복했다.