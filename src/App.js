import React, { useState, useEffect } from "react";
import "./App.css";
import { Homepage } from "./containers/homepage";
import { NotFoundPage } from "./containers/notfoundpage";
import { FrontPage } from "./containers/frontpage";

import {
  BrowserRouter as Router,
  Route, //Router는 특정 page 로 direct해주는 느낌
  Switch, //여러 Router가 있을떄 switch를 이용해서 render the first one that matches url
  Link, //hyper link 개념으로 뭐 클릭하면 글로 re route시키게
  Redirect, //지정장소로 가세요
} from "react-router-dom";


//routing 까진 끝냇고 api call axios 해서 interactive하게 server와 연동하는것만 남음. 

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={FrontPage}></Route>
        <Route exact path="/weatherInfo" component={Homepage}></Route>
        <Route exact path="/404" component={NotFoundPage}></Route>
        <Redirect to="/404" />
      </Switch>
    </Router>
  );
}

export default App;

// const Weather = () => {
//   //state initialization인듯
//   //add local state into this component
//   //useState argument: initial state
//   const [weatherInfo, setWeatherInfo] = useState([]);

//   const fetchWeatherData = () => {
//     axios.get("http://localhost:8080/api/v1/owm/retrieve/Busan").then((res) => {
//       console.log(res);
//       console.log(typeof res.data);
//       //setting state
//       //내감이 맞다면 res.data는 list라서 useState에서 []로 initial로 state해야함.
//       setWeatherInfo(res.data);
//     });
//   };

//   //component did mount 랑 비슷
//   //[] 리스트에 변화가 생기면 useEffect가 다시 trigger
//   useEffect(() => {
//     fetchWeatherData();
//   }, []);

//   //iterate weatherInfo list
//   //list안의 object를 iterate하려면 map사용해야하고 무조건 Return을 이용해서 사용해야함.
//   //각각을 component형식으로 바꿔줘야할듯.
//   return weatherInfo.map((weather, index) => {
//     return (
//       <div key={index}>
//         {/* Header */}
//         <div className="header">
//           <header className="title">
//             Weather Information in {weather.name}
//           </header>
//         </div>
//         {/* Navigation */}
//         <div className="nav">
//           <nav className="option">select other city</nav>
//         </div>
//         {/* contents */}
//         <div className="contents">
//           {/* Coordinate */}
//           <section className="coord">
//             <div className="coordInfo">
//               <h2>coordinate</h2>
//               <p>lat: {weather.coord.lat}</p>
//               <p>lon: {weather.coord.lon}</p>
//             </div>
//           </section>
//           {/* Weather */}
//           <section className="weather">
//             <div className="weatherInfo">
//               <h2> Weather</h2>
//               {weather.weather.map((item, i) => {
//                 return (
//                   <div key={i}>
//                     <span>{item.description}</span>
//                     <span>{item.main}</span>
//                   </div>
//                 );
//               })}
//             </div>
//           </section>
//           {/* main */}
//           <section className="main">
//             <div className="mainInfo">
//               <h2>main</h2>
//               <p>temp: {weather.main.temp}</p>
//               <p>tempMin: {weather.main.temp_min}</p>
//               <p>tempMax: {weather.main.temp_max}</p>
//               <p>humidity: {weather.main.humidity}</p>
//               <p>pressure: {weather.main.pressure}</p>
//               <p>feels_like: {weather.main.feels_like}</p>
//             </div>
//           </section>
//           {/* wind */}
//           <section className="wind">
//             <div className="windInfo">
//               <h2>wind</h2>
//               <p>deg: {weather.wind.deg}</p>
//               <p>speed: {weather.wind.speed}</p>
//             </div>
//           </section>
//           {/* Clouds */}
//           <section className="clouds">
//             <div className="cloudsInfo">
//               <h2>clouds:</h2>
//               <p>clouds: {weather.clouds.all}</p>
//             </div>
//           </section>
//           {/* Sys */}
//           <section className="sys">
//             <div className="sysInfo">
//               <h2>sys</h2>
//               <p>country: {weather.sys.country}</p>
//               <p>sunrise: {weather.sys.sunrise}</p>
//               <p>sunset: {weather.sys.sunset}</p>
//             </div>
//           </section>
//           {/* TimeZone */}
//           <section className="timezone">
//             <div className="timezoneInfo">
//               <h2>timezone:</h2>
//               <p>timezone: {weather.timezone}</p>
//               <p>city: {weather.name}</p>
//             </div>
//           </section>
//         </div>
//       </div>
//     );
//   });
// };

{
  /* forecast just practice */
}
{
  /* <section className="forecast">
          <div className="today">
              <div className="temp">20 &#8451</div>
              <span className="date">Monday 22th</span>
          </div>
          <div className="week">
              <div className="mon">
                  <span className="day">MON</span>
                  <img src="WeatherImageSrc/Sun_64px_3.png" alt="sun">
                  <span className="temp">25 &#8451</span>
              </div>
          </div>
          </section>
          </div>
              {/* <div className="tue">
                  <span className="day">TUE</span>
                  <img src="WeatherImageSrc/Snow_64px.png">
                  <span className="temp">20 &#8451</span>
              </div> */
}
{
  /* <div className="wed">
                <span className="day">WED</span>
                <img src="WeatherImageSrc/Sun_64px_3.png" alt="sun">
                <span className="temp">25 &#8451</span>
            </div>
            <div className="thu">
                <span className="day">THU</span>
                <img src="WeatherImageSrc/Rain_64px_1.png">
                <span className="temp">30 &#8451</span>
            </div>
            <div className="fri">
                <span className="day">FRI</span>
                <img className="frimg" src="WeatherImageSrc/Rain_64px_1.png">
                <span className="temp">27 &#8451</span>
            </div>
            <div className="sat">
                <span className="day">SAT</span>
                <img src="WeatherImageSrc/Sun_64px_3.png" alt="sun">
                <span className="temp">28 &#8451</span>
            </div>
            <div className="sun">
                <span className="day">SUN</span>
                <img src="WeatherImageSrc/Snow_64px.png">
                <span className="temp">25 &#8451</span>
            </div> */
}
