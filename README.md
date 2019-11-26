# ⭐️ 서비스 소개

밀레니엄 세대를 중심으로 **구독 경제**가 일상에 깊숙이 자리 잡고 있다. 구독 경제(subscription economy)란 소비자가 정기적으로 비용을 지급하여 원하는 상품을 배송받거나, 일정 기간 서비스를 이용하는 것을 뜻한다.

 현재 구독 경제는 2020년 594조 원 전망을 나타내며 소비의 새로운 패러다임으로 자리 잡았다. 하지만 서비스를 구매하던 기존의 방식이 익숙한 소비자들은 여전히 제한적인 서비스만을 이용하거나, 다양한 결재체계로 흩어져 구독 중인 서비스로 인해 관리에 어려움을 겪고 있다. 따라서 우리 팀은 신한 계열사들의 API들을(목록 아래 기제) 사용하여서 통합적으로 구독 서비스를 관리할 수 있는 플랫폼을 만들고자 한다.

# 📽 시연 영상
https://drive.google.com/drive/folders/1Y-TnhOSvX0GOw-QpAYguQ8f8Mc4y0hNJ

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

| AnalysisActivity | CategoryFragment | DetailedActivity |
|:---:|:---:|:---:|
|![image](https://user-images.githubusercontent.com/35513039/69621498-916f3a00-1082-11ea-88ed-a7b14d04d012.png)|![image](https://user-images.githubusercontent.com/35513039/69621573-b6fc4380-1082-11ea-859b-a790b351cfaf.png)|![image](https://user-images.githubusercontent.com/35513039/69621582-bbc0f780-1082-11ea-8ade-62eff06bc5c4.png) |

## 🂠 구현한 패턴
**Repository Pattern** \
데이터를 가져오는 곳을 패턴(일정한 규칙)을 이용하여 구현하는 방법 \
앱 내부 DB(Room, Realm 등)에서 가져올지 서버DB에서 가져올지 추상화를 한다.\
Repository 객체에서는 서버나 로컬에서 가져온 데이터를 가공하거나 데이터 흐름을 정의해 주는 역할을 한다.
이 프로젝트에서는 짧은 시간안에 신한 API를 이용해서 구현하는 것이 해커톤의 취지이기 때문에 Cache를 사용하지 않고 Retrofit 라이브러리를 사용해 Remote 만을 사용하였다. \
[참고 블로그(우아한 형제들)](http://woowabros.github.io/experience/2019/01/17/baeminapp-clean-architecture.html)
![image](https://user-images.githubusercontent.com/35513039/69628698-29732080-108f-11ea-8271-878ee284546c.png)

**Foldering**
![image](https://user-images.githubusercontent.com/35513039/69630209-1f055680-1090-11ea-9f76-63c875af537d.png)

data 패키지에서는 response객체를 쉽고 빠르게 만들어주는 [Kotlin data class File from JSON](https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-/) PlugIn 을 사용하였다.

## 📚 이용한 라이브러리
``` 
implementation 'com.google.android.material:material:1.0.0'
```
주로 cardview, recyclerview 를 커스텀하기 위해 사용한다. 또한 버튼 탭이나 스크롤 탭, 스크롤 시 상단 탭이 없어지는 AppBar를 구현할 수 있다. 

이 프로젝트에서는  CardView와 ViewPager, RecyclerView를 사용하기 위해 라이브러리는 이용하였다.

[참고자료(github)](https://github.com/material-components/material-components-android)

```
implementation 'com.squareup.retrofit2:retrofit:2.6.2'
implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.6.2'
```

서버와 HTTP 규약을 통해 데이터를 주고 받을 수 있는 라이브러리 POST,GET,PUT,DELETE 통신 매서드를 이용하여 서버에게 JSON형식으로 데이터를 주고 (request) 서버 DB의 데이터를 가져올 수 있다.(response) 

이 프로젝트에서는 JSON형식으로 주고 받을 때 call 객체와 Single 객체를 사용하였다.\
[참고자료](https://square.github.io/retrofit/)

```
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
```

## 💡 핵심 기술

## ❗️ 해커톤 준비 팁 ❗️
