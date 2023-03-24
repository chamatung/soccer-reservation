import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Home";

import MenuBar from "./MenuBar";
import SocialReservation from "../reservation/SocialReservation";

const Main = () => {
  return (
    <>
      <Home />
      <MenuBar />
      <Routes>
        <Route path='/' element={<SocialReservation />}>
          <Route path='/main' element={<SocialReservation />}></Route>
          {/* <Route path='orders' element={<Orders />}></Route>
                <Route path='/board' element={<Board />}></Route> */}
        </Route>
      </Routes>
    </>
  );
};

export default Main;
