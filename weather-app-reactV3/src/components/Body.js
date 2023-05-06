import { useEffect, useState } from "react";
import Shimmer from "./Shimmer";
import Error from "./Error";

const Body = ({ search, buttonClick }) => {
  const [weather, setWeather] = useState(null);
  const [sym, setSym] = useState(null);
  //const apiKey = `https://api.openweathermap.org/data/2.5/weather?q=${search}&units=metric&appid=a38f758c5edcf066e4c15e4bd4284d5c`;
  const apiKey = `http://localhost:8888/weather/${search}`;
  const icon = `https://openweathermap.org/img/wn/${sym}@2x.png`;

  const [initialRender, setInitialRender] = useState(true);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (weather != null) {
      if (weather.coord != null) {
        setSym(weather?.weather[0]?.icon);
      }
    }
  }, [weather]);

  async function getApi() {
    setLoading(true);
    let data = await fetch(apiKey);
    const json = await data.json();
    console.log(json);
    setLoading(false);
    setWeather(json);
  }

  useEffect(() => {
    if (initialRender) {
      setInitialRender(false);
    } else {
      getApi();
    }
  }, [buttonClick]);

  return (
    <div>
      {loading ? (
        <Shimmer />
      ) : (
        <div>
          {weather == null ? (
            <span className="flex justify-center items-center h-[10vh] w-full">
              <h1 className="font-bold  md:text-2xl text-black">
                Enter Any City Name to Get Real Time data
              </h1>
            </span>
          ) : weather.name == null ? (
            <Error />
          ) : (
            <div className="flex flex-col">
              <div className="w-full h-[60vh] pt-9 flex flex-col text-red-950">
                <p className="font-bold text-2xl text-center">{weather.name}</p>
                <p className="text-5xl mt-5 sm:text-6xl lg:text-8xl  text-center">
                  {Math.round(weather.main.temp * 10) / 10} °C
                </p>
                <p className="text-center mt-5 sm:text-xl lg:text-2xl">
                  Feel like : {Math.round(weather.main.feels_like * 10) / 10} °C
                </p>
                <p className="text-center mt-5 sm:text-xl lg:text-2xl">
                  {weather.weather[0].main}
                </p>
              </div>
              <div className="w-full  bg-white bg-opaque-10 backdrop-sepia rounded drop-shadow-lg flex justify-around items-center">
                <img
                  src={icon}
                  className="h-[100px] m-5 w-[100px] bg-gray-400 rounded-full"
                />
                <div className=" ">
                  <p className="border-b text-center">
                    {weather.main.humidity} %
                  </p>
                  <p>Humidity</p>
                </div>
                <div className=" ">
                  <p className="border-b">{weather.wind.speed} KM/H</p>
                  <p>Wind Speed</p>
                </div>
              </div>
            </div>
          )}
        </div>
      )}
    </div>
  );
};

export default Body;
